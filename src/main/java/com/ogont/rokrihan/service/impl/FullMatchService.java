package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.match.FullMatch;
import com.ogont.rokrihan.model.match.MatchEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.PlayerResultEntity;
import com.ogont.rokrihan.service.IFullMatchService;
import com.ogont.rokrihan.service.IMatchService;
import com.ogont.rokrihan.service.IPlayerResultService;
import com.ogont.rokrihan.service.IPlayerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FullMatchService implements IFullMatchService {
    public static final double ELO_RATE = 25;


    @Resource
    IMatchService matchService;
    @Resource
    IPlayerResultService playerResultService;
    @Resource
    IPlayerService playerService;
    @Override
    public FullMatch save(FullMatch fullMatch) {
        matchService.save(fullMatch.getMatchEntity());
        setMatchId(fullMatch);
        computeMmr(fullMatch);
        playerResultService.saveAll(fullMatch.getPlayerResultEntities());
        playerService.saveAll(getPlayersList(fullMatch));
        return fullMatch;
    }

    private List<PlayerEntity> getPlayersList(FullMatch fullMatch) {
        return fullMatch.getPlayerResultEntities().stream().map(PlayerResultEntity::getPlayerEntity).collect(Collectors.toList());
    }

    @Override
    public FullMatch getByMatchId(Integer id) {
        MatchEntity matchEntity = matchService.findById(id).get();
        List<PlayerResultEntity> entities = playerResultService.findAllByMatchId(matchEntity.getId());
        FullMatch fullMatch = new FullMatch();
        fullMatch.setMatchEntity(matchEntity);
        fullMatch.setPlayerResultEntities(entities);
        return fullMatch;
    }

    @Override
    public List<FullMatch> getAll() {
        List<MatchEntity> matches = matchService.getAll();
        List<FullMatch> res = new ArrayList<>();
        for (MatchEntity matchEntity : matches) {
            FullMatch fullMatch = new FullMatch();
            fullMatch.setMatchEntity(matchEntity);
            fullMatch.setPlayerResultEntities(playerResultService.findAllByMatchId(matchEntity.getId()));
            res.add(fullMatch);
        }
        return res;
    }

    @Override
    public void computeMmr(FullMatch match) {
        List<PlayerResultEntity> playerResultEntities = match.getPlayerResultEntities();
        if (playerResultEntities.size() != 2) return;
        PlayerResultEntity resultA = playerResultEntities.get(0);
        PlayerResultEntity resultB = playerResultEntities.get(1);
        compute(resultA, resultB);
        compute(resultB, resultA);
    }

    private void compute(PlayerResultEntity resultA, PlayerResultEntity resultB) {
        double resA = elo(resultA.getScore(), resultB.getScore(), resultA.getWinner() ? 1 : 0);
        resultA.setMmrChange((int) resA);
        PlayerEntity playerEntityA = resultA.getPlayerEntity();
        playerEntityA.setMmr(playerEntityA.getMmr() + (int) resA);
    }


    private double elo(Integer rA, Integer rB, Integer Sa) {
        double Ea = 1 / (1 + Math.pow(10, (rB - rA) / (double) 400));
        return rA + ELO_RATE * (Sa - Ea);
    }


    private void setMatchId(FullMatch fullMatch) {
        for (PlayerResultEntity playerResultEntity : fullMatch.getPlayerResultEntities()) {
            playerResultEntity.setMatchId(fullMatch.getMatchEntity().getId());
        }
    }
}

package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.PlayerResultEntity;
import com.ogont.rokrihan.repository.IPlayerResultRepository;
import com.ogont.rokrihan.service.IFactionService;
import com.ogont.rokrihan.service.IPlayerResultService;
import com.ogont.rokrihan.service.IPlayerService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component
public class PlayerResultService implements IPlayerResultService {
    @Resource
    IPlayerResultRepository repository;

    @Resource
    IPlayerService playerService;
    @Resource
    IFactionService factionService;


    @Override
    public List<PlayerResultEntity> refresh(List<PlayerResultEntity> resultEntities) {
        for (PlayerResultEntity resultEntity : resultEntities) {
            resultEntity.setPlayerEntity(playerService.findById(resultEntity.getPlayerId()).get());

            resultEntity.setFactionEntity(factionService.findById(resultEntity.getFactionId()).get());
        }
        return resultEntities;
    }

    @Override
    public PlayerResultEntity getLast(Integer id) {
        List<PlayerResultEntity> entities = new ArrayList<>(repository.findAllByPlayerId(id));

        entities.sort(Comparator.comparing(x -> x.getMatchEntity().getEtime()));
        if (entities.size() > 0)
            return entities.get(entities.size() - 1);
        else return null;
    }


    @Override
    public FactionEntity getBestFaction(PlayerEntity playerEntity) {
        List<PlayerResultEntity> factionEntities = findAllByPlayerId(playerEntity.getId());
        Map<FactionEntity, Integer> mmrChanges = new HashMap<>();
        for (PlayerResultEntity resultEntity : factionEntities) {
            FactionEntity faction = resultEntity.getFactionEntity();
            Integer mmr = mmrChanges.getOrDefault(faction, null);

            if (mmr == null) mmrChanges.put(faction, resultEntity.getMmrChange());
            else mmrChanges.put(faction, mmr + resultEntity.getMmrChange());
        }
        return mmrChanges.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    @Override
    public List<PlayerResultEntity> findAllByPlayerId(Integer id) {
        return repository.findAllByPlayerId(id);
    }

    @Override
    public List<PlayerResultEntity> findAllByMatchId(Integer id) {
        return repository.findAllByMatchId(id);
    }

    @Override
    public CrudRepository<PlayerResultEntity, Integer> getRepository() {
        return repository;
    }
}

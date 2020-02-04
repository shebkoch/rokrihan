package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.repository.IFactionRepository;
import com.ogont.rokrihan.service.IFactionService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Component
public class FactionService implements IFactionService {
    @Resource
    IFactionRepository repository;

    @Override
    public CrudRepository<FactionEntity, Integer> getRepository() {
        return repository;
    }

    @Override
    public void computeScoreAndSave(FactionEntity factionEntity, Boolean win, Integer score, Integer playersCount) {
        computeScoreAndSave(factionEntity.getId(), win, score, playersCount);
    }

    @Override
    public void computeScoreAndSave(Integer id, Boolean win, Integer place, Integer playersCount) {
        FactionEntity factionEntity = findById(id).get();
        factionEntity.setMatchCount(factionEntity.getMatchCount() + 1);
        BigDecimal change = new BigDecimal(((float) (playersCount + 1) / 2 - place) / playersCount);
        System.out.println(playersCount + " " + place + " " + change);
        if (win) {
            factionEntity.setWinCount(factionEntity.getWinCount() + 1);
        }

        factionEntity.setScore(factionEntity.getScore().add(change));

        save(factionEntity);
    }
}

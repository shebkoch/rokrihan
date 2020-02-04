package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.faction.FactionEntity;

public interface IFactionService extends IService<FactionEntity, Integer> {
    void computeScoreAndSave(FactionEntity factionEntity, Boolean win, Integer score, Integer playersCount);

    void computeScoreAndSave(Integer id, Boolean win, Integer score, Integer playersCount);
}

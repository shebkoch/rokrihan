package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.PlayerResultEntity;

import java.util.List;

public interface IPlayerResultService extends IService<PlayerResultEntity, Integer> {
    List<PlayerResultEntity> refresh(List<PlayerResultEntity> resultEntities);

    PlayerResultEntity getLast(Integer id);

    FactionEntity getBestFaction(PlayerEntity playerEntity);

    List<PlayerResultEntity> findAllByPlayerId(Integer id);

    List<PlayerResultEntity> findAllByMatchId(Integer id);
}

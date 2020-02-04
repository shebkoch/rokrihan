package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.player.PlayerInfoEntity;
import com.ogont.rokrihan.model.player.PlayerResultEntity;

public interface IPlayerInfoService extends IService<PlayerInfoEntity, Integer> {
    PlayerInfoEntity findByPlayerId(Integer id);
}

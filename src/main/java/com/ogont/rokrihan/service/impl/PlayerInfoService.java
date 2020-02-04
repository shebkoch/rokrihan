package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.player.PlayerInfoEntity;
import com.ogont.rokrihan.model.util.Key;
import com.ogont.rokrihan.repository.IKeyRepository;
import com.ogont.rokrihan.repository.IPlayerInfoRepository;
import com.ogont.rokrihan.service.IKeyService;
import com.ogont.rokrihan.service.IPlayerInfoService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PlayerInfoService implements IPlayerInfoService {
    @Resource
    IPlayerInfoRepository repository;

    @Override
    public CrudRepository<PlayerInfoEntity, Integer> getRepository() {
        return repository;
    }
    @Override
    public PlayerInfoEntity findByPlayerId(Integer id){
        PlayerInfoEntity playerInfoEntity = repository.findByPlayerId(id);
        if(playerInfoEntity == null) playerInfoEntity = new PlayerInfoEntity();
        playerInfoEntity.setPlayerId(id);
        return playerInfoEntity;
    }
}

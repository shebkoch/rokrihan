package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.util.Key;
import com.ogont.rokrihan.model.player.LoginUser;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.repository.IPlayerRepository;
import com.ogont.rokrihan.service.IKeyService;
import com.ogont.rokrihan.service.IPlayerService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.List;

@Component

public class PlayerService implements IPlayerService {
    @Resource
    IPlayerRepository repository;
    @Resource
    IKeyService keyService;

    @Override
    public CrudRepository<PlayerEntity, Integer> getRepository() {
        return repository;
    }

    public List<PlayerEntity> findAllByIdIn(List<Integer> ids) {
        return repository.findAllByIdIn(ids);
    }

    @Override
    public Integer getAverageMmr() {
        return repository.getAverageMmr();
    }

    @Override
    public PlayerEntity getByName(String name){
        return repository.findByName(name);
    }

    public List<PlayerEntity> findTop(Integer count){
        return null;
    }
}

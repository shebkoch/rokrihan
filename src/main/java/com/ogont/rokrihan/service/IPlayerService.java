package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.player.LoginUser;
import com.ogont.rokrihan.model.player.PlayerEntity;

import javax.security.auth.login.LoginException;
import java.util.List;

public interface IPlayerService extends IService<PlayerEntity, Integer> {
    Integer getAverageMmr();
    List<PlayerEntity> findAllByIdIn(List<Integer> ids);
    PlayerEntity getByName(String name);
}

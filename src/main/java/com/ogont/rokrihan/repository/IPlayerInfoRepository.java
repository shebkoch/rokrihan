package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.PlayerInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerInfoRepository extends CrudRepository<PlayerInfoEntity, Integer> {
    PlayerInfoEntity findByPlayerId(Integer id);
}

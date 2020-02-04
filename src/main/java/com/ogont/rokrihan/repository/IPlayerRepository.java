package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.player.PlayerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends CrudRepository<PlayerEntity, Integer> {
    PlayerEntity findByName(String name);
    @Query("SELECT AVG(p.mmr) from PlayerEntity p")
    Integer getAverageMmr();
    List<PlayerEntity> findAllByIdIn(List<Integer> ids);

}

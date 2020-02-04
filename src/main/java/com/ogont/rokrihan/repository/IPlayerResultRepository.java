package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.player.PlayerResultEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPlayerResultRepository extends CrudRepository<PlayerResultEntity, Integer> {
    List<PlayerResultEntity> findAllByPlayerId(Integer id);

    List<PlayerResultEntity> findAllByMatchId(Integer id);
//    List<PlayerResultEntity> findAllByIdIn(List<Integer> ids);
//    @Query("select PlayerResultEntity " +
//            "from PlayerResultEntity p, MatchEntity m where p.playerId = 0 and p.matchId =" +
//            "m.id order by m.etime desc")
//    List<PlayerResultEntity> getLast(Integer id);
}

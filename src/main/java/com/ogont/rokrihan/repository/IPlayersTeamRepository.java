package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.team.PlayersTeamEntity;
import com.ogont.rokrihan.model.player.team.TeamEntity;
import com.ogont.rokrihan.model.util.Key;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayersTeamRepository extends CrudRepository<PlayersTeamEntity, Integer> {
    List<PlayersTeamEntity> getByPlayerEntity(PlayerEntity playersTeamEntity);
    List<PlayersTeamEntity> getAllByTeamId(Integer team_id);
    @Query("SELECT pt.playerEntity from PlayersTeamEntity pt where pt.teamEntity =:teamEntity")
    List<PlayerEntity> getTeamMates(TeamEntity teamEntity);
}

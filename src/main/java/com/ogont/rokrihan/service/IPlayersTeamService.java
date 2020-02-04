package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.team.PlayersTeamEntity;
import com.ogont.rokrihan.model.player.team.TeamEntity;

import java.util.List;
import java.util.Map;

public interface IPlayersTeamService extends IService<PlayersTeamEntity, Integer> {

    Map<TeamEntity,List<PlayerEntity>> getTeamMates(PlayerEntity playerEntity);
}

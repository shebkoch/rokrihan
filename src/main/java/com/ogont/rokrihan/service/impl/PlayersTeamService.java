package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.player.LoginUser;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.team.PlayersTeamEntity;
import com.ogont.rokrihan.model.player.team.TeamEntity;
import com.ogont.rokrihan.model.util.Key;
import com.ogont.rokrihan.repository.IPlayerRepository;
import com.ogont.rokrihan.repository.IPlayersTeamRepository;
import com.ogont.rokrihan.service.IKeyService;
import com.ogont.rokrihan.service.IPlayerService;
import com.ogont.rokrihan.service.IPlayersTeamService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlayersTeamService implements IPlayersTeamService {
    @Resource
    IPlayersTeamRepository repository;

    @Override
    public CrudRepository<PlayersTeamEntity, Integer> getRepository() {
        return repository;
    }

    @Override
    public Map<TeamEntity,List<PlayerEntity>> getTeamMates(PlayerEntity playerEntity){
        List<PlayersTeamEntity> list = repository.getByPlayerEntity(playerEntity);
        Map<TeamEntity,List<PlayerEntity>> teamMates = new HashMap<>();

        for (PlayersTeamEntity playersTeamEntity : list){
            TeamEntity teamEntity = playersTeamEntity.getTeamEntity();
            teamMates.put(teamEntity, repository.getTeamMates(teamEntity));
        }
        return teamMates;
    }
}

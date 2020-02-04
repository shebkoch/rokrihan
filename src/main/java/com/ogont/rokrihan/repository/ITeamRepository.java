package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.player.team.TeamEntity;
import com.ogont.rokrihan.model.util.Key;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends CrudRepository<TeamEntity, Integer> {

}

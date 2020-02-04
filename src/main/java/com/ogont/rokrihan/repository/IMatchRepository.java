package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.match.MatchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchRepository extends CrudRepository<MatchEntity, Integer> {
    MatchEntity findTopByRating(boolean isRating);
}

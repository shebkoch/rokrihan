package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.match.MatchEntity;
import com.ogont.rokrihan.repository.IMatchRepository;
import com.ogont.rokrihan.service.IMatchService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MatchService implements IMatchService {
    @Resource
    IMatchRepository repository;

    @Override
    public CrudRepository<MatchEntity, Integer> getRepository() {
        return repository;
    }

    @Override
    public MatchEntity getLast() {
        return repository.findTopByRating(true);
    }
}

package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.match.MatchEntity;

public interface IMatchService extends IService<MatchEntity, Integer> {
    public MatchEntity getLast();
}

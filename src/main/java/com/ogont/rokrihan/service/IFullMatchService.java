package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.match.FullMatch;

import java.util.List;

public interface IFullMatchService {
    FullMatch save(FullMatch fullMatch);

    FullMatch getByMatchId(Integer id);

    List<FullMatch> getAll();

    void computeMmr(FullMatch match);
}

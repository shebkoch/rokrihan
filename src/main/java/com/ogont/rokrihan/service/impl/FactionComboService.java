package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.faction.FactionComboEntity;
import com.ogont.rokrihan.repository.IFactionComboRepository;
import com.ogont.rokrihan.service.IFactionComboService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FactionComboService implements IFactionComboService {
    @Resource
    IFactionComboRepository repository;

    @Override
    public CrudRepository<FactionComboEntity, Integer> getRepository() {
        return repository;
    }

}
package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.faction.FactionComboEntity;
import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.repository.IFactionComboRepository;
import com.ogont.rokrihan.service.IFactionComboService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FactionComboService implements IFactionComboService {
    @Resource
    IFactionComboRepository repository;
    public FactionEntity getEnemy(Integer factionId){
        List<FactionComboEntity> factionsCombo = getAll();
        for(FactionComboEntity factionComboEntity : factionsCombo){
            if (factionComboEntity.getFactionEntity1().getId().equals(factionId)) return factionComboEntity.getFactionEntity2();
            if (factionComboEntity.getFactionEntity2().getId().equals(factionId)) return factionComboEntity.getFactionEntity1();
        }
        return null;
    }
    @Override
    public CrudRepository<FactionComboEntity, Integer> getRepository() {
        return repository;
    }

}
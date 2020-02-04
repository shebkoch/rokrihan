package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.util.DistributeData;
import com.ogont.rokrihan.model.faction.FactionComboEntity;
import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.service.IFactionComboService;
import com.ogont.rokrihan.service.IFactionDistributorService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component
public class FactionDistributorService implements IFactionDistributorService {
    @Resource
    IFactionComboService factionComboService;

    public Map<PlayerEntity, FactionEntity> distribute(List<PlayerEntity> players) {
        DistributeData data = new DistributeData();
        data.setFactions(factionComboService.getAll());
        data.setPlayers(players);
        return distribute(data);
    }

    @Override
    public Map<PlayerEntity, FactionEntity> distribute(DistributeData data) {
        List<FactionEntity> factions = new ArrayList<>();
        for (FactionComboEntity x : data.getFactions()) {
            factions.add(x.getFactionEntity1());
            factions.add(x.getFactionEntity2());
        }
        Map<PlayerEntity, FactionEntity> result = new HashMap<>();
        for (PlayerEntity playerEntity : data.getPlayers()) {
            FactionEntity factionEntity = getRandomDistinct(factions);
            result.put(playerEntity, factionEntity);
        }
        return result;

    }

    private FactionEntity getRandomDistinct(List<FactionEntity> factionEntities) {
        Random random = new Random();
        int id = random.nextInt(factionEntities.size());
        FactionEntity result = factionEntities.get(id);
        factionEntities.remove(id);
        return result;
    }
}


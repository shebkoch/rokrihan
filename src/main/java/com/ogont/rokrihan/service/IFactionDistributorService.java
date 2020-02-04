package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.util.DistributeData;
import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;

import java.util.Map;

public interface IFactionDistributorService {
    //s =10+0+4+6=20
    //c = ni/ s;
    //ch = 100 / n;
    //ch /=  c
    //1:1/2=  8
    //2:1/20 = 80
    //3:1/5 = 20
    //4:3/10 = 13
    Map<PlayerEntity, FactionEntity> distribute(DistributeData data);
}

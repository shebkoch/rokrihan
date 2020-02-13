package com.ogont.rokrihan.model.util;

import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.PlayerInfoEntity;

public class DistributeResult {
    private PlayerEntity playerEntity;
    private PlayerInfoEntity playerInfoEntity;
    private FactionEntity factionEntity;

    public DistributeResult(PlayerEntity playerEntity, PlayerInfoEntity playerInfoEntity, FactionEntity factionEntity) {
        this.playerEntity = playerEntity;
        this.playerInfoEntity = playerInfoEntity;
        this.factionEntity = factionEntity;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public PlayerInfoEntity getPlayerInfoEntity() {
        return playerInfoEntity;
    }

    public void setPlayerInfoEntity(PlayerInfoEntity playerInfoEntity) {
        this.playerInfoEntity = playerInfoEntity;
    }

    public FactionEntity getFactionEntity() {
        return factionEntity;
    }

    public void setFactionEntity(FactionEntity factionEntity) {
        this.factionEntity = factionEntity;
    }
}

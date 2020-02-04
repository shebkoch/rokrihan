package com.ogont.rokrihan.model.util;

import com.ogont.rokrihan.model.faction.FactionComboEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;

import java.util.List;

public class DistributeData {
    private List<FactionComboEntity> factions;
    private List<PlayerEntity> players;

    public List<FactionComboEntity> getFactions() {
        return factions;
    }

    public void setFactions(List<FactionComboEntity> factions) {
        this.factions = factions;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }
}

package com.ogont.rokrihan.model.match;


import com.ogont.rokrihan.model.player.PlayerResultEntity;

import java.time.Duration;
import java.util.List;

public class FullMatch {
    private MatchEntity matchEntity;
    private List<PlayerResultEntity> playerResultEntities;

    public Long duration(){
        Duration duration = Duration.between(matchEntity.getCtime().toLocalDateTime(), matchEntity.getEtime().toLocalDateTime());
        return duration.getSeconds() / 60;
    }

    public MatchEntity getMatchEntity() {
        return matchEntity;
    }

    public void setMatchEntity(MatchEntity matchEntity) {
        this.matchEntity = matchEntity;
    }

    public List<PlayerResultEntity> getPlayerResultEntities() {
        return playerResultEntities;
    }

    public void setPlayerResultEntities(List<PlayerResultEntity> playerResultEntities) {
        this.playerResultEntities = playerResultEntities;
    }
}

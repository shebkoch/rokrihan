package com.ogont.rokrihan.model.player.team;

import com.ogont.rokrihan.model.IGenericEntity;
import com.ogont.rokrihan.model.player.PlayerEntity;

import javax.persistence.*;


@Entity
@Table(name = "players_team", schema = "public", catalog = "rokrihan")
public class PlayersTeamEntity implements IGenericEntity<Integer> {
    private Integer id;
    private PlayerEntity playerEntity;
    private TeamEntity teamEntity;

    private Integer playerId;
    private Integer teamId;

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id", insertable = false, updatable = false)
    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
    @OneToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TeamEntity getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

    @Basic
    @Column(name = "player_id")
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
    @Basic
    @Column(name = "team_id")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}

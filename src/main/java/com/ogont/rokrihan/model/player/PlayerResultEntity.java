package com.ogont.rokrihan.model.player;

import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.IGenericEntity;
import com.ogont.rokrihan.model.match.MatchEntity;

import javax.persistence.*;

@Entity
@Table(name = "player_result", schema = "public", catalog = "rokrihan")
public class PlayerResultEntity  implements IGenericEntity<Integer> {
    private int id;
    private Integer score;
    private Integer mmrChange;
    private Boolean isWinner;
    private Integer matchId;
    private Integer playerId;
    private Integer factionId;

    private MatchEntity matchEntity;
    private PlayerEntity playerEntity;
    private FactionEntity factionEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "match_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MatchEntity getMatchEntity() {
        return matchEntity;
    }

    public void setMatchEntity(MatchEntity matchEntity) {
        this.matchEntity = matchEntity;
    }
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", referencedColumnName = "id", insertable = false, updatable = false)
    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faction_id", referencedColumnName = "id", insertable = false, updatable = false)
    public FactionEntity getFactionEntity() {
        return factionEntity;
    }

    public void setFactionEntity(FactionEntity factionEntity1) {
        this.factionEntity = factionEntity1;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column(name = "mmr_change")
    public Integer getMmrChange() {
        return mmrChange;
    }

    public void setMmrChange(Integer mmrChange) {
        this.mmrChange = mmrChange;
    }

    @Basic
    @Column(name = "is_winner")
    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    @Basic
    @Column(name = "match_id")
    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
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
    @Column(name = "faction_id")
    public Integer getFactionId() {
        return factionId;
    }

    public void setFactionId(Integer factionId) {
        this.factionId = factionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerResultEntity that = (PlayerResultEntity) o;

        if (id != that.id) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (mmrChange != null ? !mmrChange.equals(that.mmrChange) : that.mmrChange != null) return false;
        if (isWinner != null ? !isWinner.equals(that.isWinner) : that.isWinner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (mmrChange != null ? mmrChange.hashCode() : 0);
        result = 31 * result + (isWinner != null ? isWinner.hashCode() : 0);
        return result;
    }
}

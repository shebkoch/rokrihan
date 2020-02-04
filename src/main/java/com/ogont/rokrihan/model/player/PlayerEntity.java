package com.ogont.rokrihan.model.player;

import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.IGenericEntity;

import javax.persistence.*;

@Entity
@Table(name = "player", schema = "public", catalog = "rokrihan")
public class PlayerEntity  implements IGenericEntity<Integer> {
    private int id;
    private String name;
    private Integer matchCount;
    private Integer winCount;
    private Integer mmr;
    private String password;

    private FactionEntity bestFactionEntity;

    private static final int START_MMR = 2000;

    public PlayerEntity() {
        matchCount = 0;
        winCount = 0;
        mmr = START_MMR;
    }

    public PlayerEntity(String name, String password) {
        this();
        this.name = name;
        this.password = password;
    }

    @OneToOne
    @JoinColumn(name = "best_faction", referencedColumnName = "id", insertable = false, updatable = false)
    public FactionEntity getBestFactionEntity() {
        return bestFactionEntity;
    }

    public void setBestFactionEntity(FactionEntity bestFactionEntity) {
        this.bestFactionEntity = bestFactionEntity;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "match_count")
    public Integer getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(Integer matchCount) {
        this.matchCount = matchCount;
    }

    @Basic
    @Column(name = "win_count")
    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }

    @Basic
    @Column(name = "mmr")
    public Integer getMmr() {
        return mmr;
    }

    public void setMmr(Integer mmr) {
        this.mmr = mmr;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerEntity that = (PlayerEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (matchCount != null ? !matchCount.equals(that.matchCount) : that.matchCount != null) return false;
        if (winCount != null ? !winCount.equals(that.winCount) : that.winCount != null) return false;
        if (mmr != null ? !mmr.equals(that.mmr) : that.mmr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (matchCount != null ? matchCount.hashCode() : 0);
        result = 31 * result + (winCount != null ? winCount.hashCode() : 0);
        result = 31 * result + (mmr != null ? mmr.hashCode() : 0);
        return result;
    }
}

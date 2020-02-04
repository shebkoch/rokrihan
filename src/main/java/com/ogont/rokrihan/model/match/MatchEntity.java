package com.ogont.rokrihan.model.match;

import com.ogont.rokrihan.model.IGenericEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "match", schema = "public", catalog = "rokrihan")
public class MatchEntity implements IGenericEntity<Integer> {
    private int id;
    private Timestamp ctime;
    private Timestamp etime;
    private Boolean isRating;
    private Integer winnerScore;

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
    @Column(name = "ctime")
    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    @Basic
    @Column(name = "etime")
    public Timestamp getEtime() {
        return etime;
    }

    public void setEtime(Timestamp etime) {
        this.etime = etime;
    }

    @Basic
    @Column(name = "is_rating")
    public Boolean getRating() {
        return isRating;
    }

    public void setRating(Boolean rating) {
        isRating = rating;
    }

    @Basic
    @Column(name = "winner_score")
    public Integer getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(Integer winnerScore) {
        this.winnerScore = winnerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchEntity that = (MatchEntity) o;

        if (id != that.id) return false;
        if (ctime != null ? !ctime.equals(that.ctime) : that.ctime != null) return false;
        if (etime != null ? !etime.equals(that.etime) : that.etime != null) return false;
        if (isRating != null ? !isRating.equals(that.isRating) : that.isRating != null) return false;
        if (winnerScore != null ? !winnerScore.equals(that.winnerScore) : that.winnerScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ctime != null ? ctime.hashCode() : 0);
        result = 31 * result + (etime != null ? etime.hashCode() : 0);
        result = 31 * result + (isRating != null ? isRating.hashCode() : 0);
        result = 31 * result + (winnerScore != null ? winnerScore.hashCode() : 0);
        return result;
    }
}

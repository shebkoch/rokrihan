package com.ogont.rokrihan.model.player;

import com.ogont.rokrihan.model.IGenericEntity;

import javax.persistence.*;

@Entity
@Table(name = "player_info", schema = "public", catalog = "rokrihan")
public class PlayerInfoEntity implements IGenericEntity<Integer> {
    private Integer id;
    private Integer playerId;
    private byte[] avatar;

    public void setId(Integer id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    public Integer getId() {
        return id;
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
    @Column(name = "avatar")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}

package com.ogont.rokrihan.model.player.team;

import com.ogont.rokrihan.model.IGenericEntity;

import javax.persistence.*;


@Entity
@Table(name = "team", schema = "public", catalog = "rokrihan")
public class TeamEntity implements IGenericEntity<Integer> {
    private int id;
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

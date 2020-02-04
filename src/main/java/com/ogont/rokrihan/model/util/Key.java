package com.ogont.rokrihan.model.util;

import com.ogont.rokrihan.model.IGenericEntity;

import javax.persistence.*;

@Entity
@Table(name = "key", schema = "public", catalog = "rokrihan")
public class Key implements IGenericEntity<Integer> {
    private Integer id;
    private String key;
    private Integer count;

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
    @Column(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

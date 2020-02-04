package com.ogont.rokrihan.model.faction;

import com.ogont.rokrihan.model.IGenericEntity;

import javax.persistence.*;

@Entity
@Table(name = "faction_combo", schema = "public", catalog = "rokrihan")
public class FactionComboEntity implements IGenericEntity<Integer> {
    private Integer id;
    private Integer faction1Id;
    private Integer faction2Id;

    private FactionEntity factionEntity1;
    private FactionEntity factionEntity2;

    public FactionComboEntity() {
    }

    public FactionComboEntity(Integer faction1Id, Integer faction2Id) {
        this.faction1Id = faction1Id;
        this.faction2Id = faction2Id;
    }

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "faction1_id")
    public Integer getFaction1Id() {
        return faction1Id;
    }

    public void setFaction1Id(Integer faction1Id) {
        this.faction1Id = faction1Id;
    }
    @Basic
    @Column(name = "faction2_id")
    public Integer getFaction2Id() {
        return faction2Id;
    }

    public void setFaction2Id(Integer faction2Id) {
        this.faction2Id = faction2Id;
    }

    @OneToOne
    @JoinColumn(name = "faction1_id", referencedColumnName = "id", insertable = false, updatable = false)
    public FactionEntity getFactionEntity1() {
        return factionEntity1;
    }

    public void setFactionEntity1(FactionEntity factionEntity1) {
        this.factionEntity1 = factionEntity1;
    }
    @OneToOne
    @JoinColumn(name = "faction2_id", referencedColumnName = "id", insertable = false, updatable = false)
    public FactionEntity getFactionEntity2() {
        return factionEntity2;
    }

    public void setFactionEntity2(FactionEntity factionEntity2) {
        this.factionEntity2 = factionEntity2;
    }

}

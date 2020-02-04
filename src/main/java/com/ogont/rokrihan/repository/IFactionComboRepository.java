package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.faction.FactionComboEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactionComboRepository extends CrudRepository<FactionComboEntity, Integer> {
}

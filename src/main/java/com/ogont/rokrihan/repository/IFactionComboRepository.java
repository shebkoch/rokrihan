package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.faction.FactionComboEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFactionComboRepository extends CrudRepository<FactionComboEntity, Integer> {
}

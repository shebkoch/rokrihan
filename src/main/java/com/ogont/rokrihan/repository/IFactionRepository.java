package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.faction.FactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactionRepository extends CrudRepository<FactionEntity, Integer> {
}

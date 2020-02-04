package com.ogont.rokrihan.repository;

import com.ogont.rokrihan.model.util.Key;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKeyRepository extends CrudRepository<Key, Integer> {
    public Key getFirstByKey(String key);
}

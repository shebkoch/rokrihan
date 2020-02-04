package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.util.Key;
import com.ogont.rokrihan.repository.IKeyRepository;
import com.ogont.rokrihan.service.IKeyService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KeyService implements IKeyService {
    @Resource
    IKeyRepository repository;

    @Override
    public CrudRepository<Key, Integer> getRepository() {
        return repository;
    }

    @Override
    public Key getFirstByKey(String key) {
        return repository.getFirstByKey(key);
    }
}

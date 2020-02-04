package com.ogont.rokrihan.service;

import com.ogont.rokrihan.model.util.Key;

public interface IKeyService extends IService<Key, Integer> {
    public Key getFirstByKey(String key);
}

package com.example.showcase.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class StorageService {
    private static Map<String, Integer> store;

    public StorageService() {
        store = Map.of("prod", 12, "oprod", 1);
    }

    public Map<String, Integer> getStore() {
        return Collections.unmodifiableMap(store);
    }

}

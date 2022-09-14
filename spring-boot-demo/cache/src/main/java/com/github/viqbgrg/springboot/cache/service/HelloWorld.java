package com.github.viqbgrg.springboot.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloWorld {
    private final DataService dataService;

    public HelloWorld(DataService dataService) {
        this.dataService = dataService;
    }

    @Cacheable(value = "test")
    public String longToString(Long value) {
        return dataService.longToString(value);
    }

}

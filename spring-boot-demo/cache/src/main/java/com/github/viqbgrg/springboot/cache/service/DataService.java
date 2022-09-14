package com.github.viqbgrg.springboot.cache.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    public String longToString(Long value) {
        return "long: " + value;
    }
}

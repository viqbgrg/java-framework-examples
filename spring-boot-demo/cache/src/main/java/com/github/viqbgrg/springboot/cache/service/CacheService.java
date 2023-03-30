package com.github.viqbgrg.springboot.cache.service;

import com.github.viqbgrg.springboot.cache.model.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Cacheable(cacheNames = "cacheNameTest")
    public String cache(String name) {
        return "cache " + name;
    }

    @Cacheable(cacheNames = "cacheNameTest", key = "#person.name+#person.age")
    public String cachePerson(Person person) {
        return person.toString();
    }

}

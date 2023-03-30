package com.github.viqbgrg.springboot.cache.cacheable

import com.github.viqbgrg.springboot.cache.model.Person
import com.github.viqbgrg.springboot.cache.service.CacheService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cache.CacheManager
import spock.lang.Specification

@SpringBootTest
class CacheableTest extends Specification {

    @Autowired
    CacheManager cacheManager

    @Autowired
    CacheService cacheService

    def "cacheName"() {
        given:
        def key = "name"
        cacheService.cache(key)
        when:
        def cache = cacheManager.getCache("cacheNameTest")
        then:
        cache.get(key, String.class) == "cache name"
    }

    def "cachePojoName"() {
        given:
        def person = new Person()
        person.setAge(22)
        person.setName("小明")
        cacheService.cachePerson(person)
        when:
        def cache = cacheManager.getCache("cacheNameTest")
        then:
        cache.evictIfPresent("小明22")
    }
}

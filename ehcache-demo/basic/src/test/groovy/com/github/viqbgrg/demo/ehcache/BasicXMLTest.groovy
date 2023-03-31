package com.github.viqbgrg.demo.ehcache

import org.ehcache.Cache
import org.ehcache.CacheManager
import spock.lang.Shared
import spock.lang.Specification

class BasicXMLTest extends Specification {

    @Shared CacheManager manager

    def setupSpec() {
        def l = new BasicXML()
        manager = l.getCacheManager()
    }

    def "GetCacheManager"() {
        expect:
        manager != null
    }

    def "arrayListTest"() {
        given:
        def cache = manager.getCache("listCache", String.class, String.class)
        when:
        Arrays.asList("a", "b")
        cache.put("test", "b")
        then:
        def get = cache.get("test")
        get != null
        get == "b"
    }

    def cleanupSpec() {
        manager.close()
    }
}

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

    def "stringTest"() {
        given:
        def cache = manager.getCache("basicCache", Long.class, String.class)
        when:
        cache.put(1L, "b")
        then:
        def get = cache.get(1L)
        get != null
        get == "b"
    }

    def "arrayListTest"() {
        given:
        def cache = manager.getCache("listCache", String.class, ArrayList<String>.class)
        when:
        def list = new ArrayList<String>()
        list.add("a")
        list.add("b")
        cache.put("test", list)
        then:
        def get = cache.get("test")
        get != null
        get.size() == 2
    }

    def cleanupSpec() {
        manager.close()
    }
}

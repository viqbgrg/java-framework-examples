package com.github.viqbgrg.springboot.cache.content

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cache.CacheManager
import spock.lang.Specification

@SpringBootTest
class CacheBeanTest extends Specification {
    @Autowired
    CacheManager cacheManager;

    def "测试 cache bean 有没有自动生成"() {
        when:
        def bean = cacheManager.getCache("test")
        then:
        bean != null
    }

    def "cache 泛型"() {
        when:
        def bean = cacheManager.getCache("test")
        bean.put(1L, "bbbbb")
        then:
        bean.get(1L, String.class) == "bbbbb"

    }
}


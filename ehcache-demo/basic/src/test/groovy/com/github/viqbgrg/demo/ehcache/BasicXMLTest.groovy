package com.github.viqbgrg.demo.ehcache

import spock.lang.Specification

class BasicXMLTest extends Specification {



    def "GetCacheManager"() {
        given:
        def l = new BasicXML()
        when:
        def manager = l.getCacheManager()
        then:
        manager != null
    }
}

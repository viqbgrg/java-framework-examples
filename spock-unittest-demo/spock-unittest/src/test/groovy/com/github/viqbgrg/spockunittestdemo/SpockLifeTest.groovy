package com.github.viqbgrg.spockunittestdemo

import spock.lang.Specification

class SpockLifeTest extends Specification {
    def setupSpec() {
        println("只运行一次")
    }
    def setup() {
        println("运行每个方法都会执行一次")
    }
    def "生命周期测试"() {
        given:
        println("given")
        when:
        println("when")
        and:
        println("when1")
        then:
        println("then")
        when:
        println("when2")
        then:
        println("then2")
    }

    def "测试整个类"() {
        expect:
        println("expect")
    }
}

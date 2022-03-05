package com.github.viqbgrg.spockunittestdemo

import com.github.viqbgrg.spockunittestdemo.entity.Person
import spock.lang.Specification

/**
 * stub
 * mock 等属性不可能在下面给吗
 */
class SharedStubTest extends Specification{

    Person person = Stub()

    def "更改person属性"(){
        given:
        person.getUsername() >> "哈哈"
        expect:
        person.getUsername() == "哈哈"
    }



    def "同一个person"(){
        given:
        person.getUsername() >> "你好"
        expect:
        person.getUsername() == "你好"
    }

}

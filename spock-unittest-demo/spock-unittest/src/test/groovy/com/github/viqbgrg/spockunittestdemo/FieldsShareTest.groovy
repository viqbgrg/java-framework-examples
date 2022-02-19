package com.github.viqbgrg.spockunittestdemo

import spock.lang.Shared
import spock.lang.Specification

/**
 * 在类中实例化一个变量
 * 可以共享的,执行每个方法都不变
 * 每次都初始化一下
 */
class FieldsShareTest extends Specification {
    @Shared share = new ClassA()

    def "第一个"(){
        expect:
        share.print(1)
    }

    def "第二个"(){
        expect:
        share.print(2)
    }



    def "中文乱码"(){
        expect:
        println("我是中文")
    }
}

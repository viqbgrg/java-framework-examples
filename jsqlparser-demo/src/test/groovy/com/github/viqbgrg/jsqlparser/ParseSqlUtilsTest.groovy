package com.github.viqbgrg.jsqlparser

import spock.lang.Specification

class ParseSqlUtilsTest extends Specification {
    def "test getTableName"() {
        def utils = new ParseSqlUtils()
        def sql = "select * from p"
        expect:
            utils.getTableName(sql) == "p"
    }

    def "拼写权限"() {

    }
}

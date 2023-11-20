package com.github.viqbgrg.demo.thymeleaf

import spock.lang.Specification

class TemplateConvertUtilTest extends Specification {
    def "LoadingTemplateAndConvertToString"() {
        expect:
        def map = [name: "Jerry", age: 42, email: "test@email.com"]
        TemplateConvertUtil.loadingTemplateAndConvertToString(map, "index")
    }
}

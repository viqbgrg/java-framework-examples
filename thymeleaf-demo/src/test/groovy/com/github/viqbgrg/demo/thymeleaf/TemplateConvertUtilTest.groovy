package com.github.viqbgrg.demo.thymeleaf

import spock.lang.Specification

class TemplateConvertUtilTest extends Specification {
    def "LoadingTemplateAndConvertToString"() {
        expect:
        def map = [name: "Jerry", age: 42, email: "test@email.com"]
        def string = TemplateConvertUtil.loadingTemplateAndConvertToString(map, "index")
        print(string)
    }


    def "classpath"() {
        expect:
        def path = TemplateConvertUtil.class.getClassLoader().getResource("index.html").getPath()
        print(path)
    }
}

package com.github.viqbgrg.spingdocdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest
class SpringdocTest extends Specification {

    @Autowired
    MockMvc mvc

    def "result"() {
        expect: "controller is available"
        mvc.perform(MockMvcRequestBuilders.get("/v3/api-docs"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"))
    }
}

package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

/**
 * @author hhj
 */
public class JsonIgnoreTest {
    @Data
    class F{
        private String name;
        private String name1;
    }
    @Data
    @EqualsAndHashCode(callSuper=false)
    @JsonIgnoreProperties(value = { "name1" })
    class S extends F{
        private String sName;
        @JsonIgnore
        private String sName1;
    }

    @Test
    void jsonIgnoreTest() throws JsonProcessingException {
        S s = new S();
        s.setSName("sName");
        s.setSName1("sName1");
        s.setName("name");
        s.setName1("name1");
        ObjectMapper mapper = new ObjectMapper();
        String s1 = mapper.writeValueAsString(s);
        System.out.println(s1);
    }
}

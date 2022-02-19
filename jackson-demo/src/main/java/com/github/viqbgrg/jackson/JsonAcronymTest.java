package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonAcronymTest {
//    private static ObjectMapper objectMapper;
//
//    @BeforeAll
//    public static void setup() {
//        objectMapper = JsonMapper.builder().configure(MapperFeature.USE_STD_BEAN_NAMING, true).build();
//    }
    @Test
    void listToString() throws JsonProcessingException {
        ObjectMapper objectMapper = JsonMapper.builder().visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).build();
        A a = new A();
        a.setAb("11111");
        String s = objectMapper.writeValueAsString(a);
        System.out.println(s);
    }

    public static class A{
        private String Ab;

        public String getAb() {
            return Ab;
        }

        public void setAb(String ab) {
            Ab = ab;
        }
    }
}

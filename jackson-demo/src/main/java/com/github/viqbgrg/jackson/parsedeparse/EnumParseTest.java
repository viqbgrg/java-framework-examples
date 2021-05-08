package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.viqbgrg.jackson.JsonBaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hhj
 */
public class EnumParseTest extends JsonBaseTest {


    @Test
    void parseEnumTest() throws JsonProcessingException {
        String s = objectMapper.writeValueAsString(Animal.values());
        System.out.println(s);
        String s1 = objectMapper.writeValueAsString(Animal.PIG);
        System.out.println(s1);
    }

    @Test
    void parseEnumMapTest() throws JsonProcessingException {
        Map<Animal, String> collect = Arrays.stream(Animal.values()).collect(Collectors.toMap(k -> k, Animal::getName));
        String s = objectMapper.writeValueAsString(collect);
        System.out.println(s);
    }
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public static enum Animal{
        PIG("猪"),CHICKEN("鸡");
        private String name;

        Animal(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }
    }
}

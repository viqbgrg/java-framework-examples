package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.viqbgrg.jackson.JsonBaseTest;
import org.junit.jupiter.api.Test;

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

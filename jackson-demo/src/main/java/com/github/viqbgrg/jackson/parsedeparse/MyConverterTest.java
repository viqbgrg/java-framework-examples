package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.viqbgrg.jackson.JsonBaseTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MyConverterTest extends JsonBaseTest {

    @Test
    void convert() throws JsonProcessingException {
        String jsonString = "{\n" +
                "    \"username\": \"xiaoming\",\n" +
                "    \"roleId\": \"admin\"\n" +
                "}";
        User user = objectMapper.readValue(jsonString, User.class);
        assertThat(user.getRoleId()).isEqualTo(1);

    }
}
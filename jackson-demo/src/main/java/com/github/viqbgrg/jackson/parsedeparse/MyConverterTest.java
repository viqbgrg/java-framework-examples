package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.viqbgrg.jackson.JsonBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MyConverterTest extends JsonBaseTest {

    @Test
    void convert() throws JsonProcessingException {
        String jsonString = "{\n" +
                "    \"username\": \"xiaoming\",\n" +
                "    \"sex\": \"man\",\n" +
                "    \"roleId\": \"admin\"\n" +
                "}";
        User user = objectMapper.readValue(jsonString, User.class);
        assertThat(user.getRoleId()).isEqualTo(1);

    }

    @Test
    void convert2() throws JsonProcessingException {
        User user = new User();
        user.setUsername("小明");
        int code = RoleEnum.USER.getCode();
        user.setRoleId(code);
        String s = objectMapper.writeValueAsString(user);
        log.info(s);
    }
}
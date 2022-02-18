package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DataParseTest {

    @Test
    public void dataTest() throws JsonProcessingException {
        String json= "{\"data\": \"2022-02-15T11:31:43.509Z\"}";
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        MyData myData = objectMapper.readValue(json, MyData.class);
        System.out.println(myData.getData().toString());
    }

    @Data
    public static class MyData{

        @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        private LocalDateTime data;
    }
}

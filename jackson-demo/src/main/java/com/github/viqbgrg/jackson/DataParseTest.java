package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataParseTest {

    @Test
    public void dataTest() throws JsonProcessingException {
        String json= "{\"data\": \"2022-02-15T11:31:43.509\"}";
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        MyData myData = objectMapper.readValue(json, MyData.class);
        System.out.println(myData.getData().toString());
    }

    @Test
    public void dataListTest() throws JsonProcessingException {
        String json= "[{\"data\": \"2022-02-15T11:31:43.509Z\"}]";
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        TypeReference<List<MyData>> typeRef
                = new TypeReference<>() {
        };
        List<MyData> myData = objectMapper.readValue(json, typeRef);
        System.out.println(myData.get(0).getData().toString());
    }

    @Test
    public void dataFormatTest() throws JsonProcessingException {
        String json= "{\"data\": \"2022-02-15T11:31:43.5Z\"}";
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        MyData myData = objectMapper.readValue(json, MyData.class);
        System.out.println(myData.getData().toString());
    }

    @Data
    public static class MyData{

        @JsonFormat(locale="zh",shape=JsonFormat.Shape.STRING, timezone="GMT+8", pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
        private LocalDateTime data;
    }

    @Test
    public void dataTest1() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.");
        System.out.println(LocalDateTime.parse("2013-10-07 12:13:27.132", dateFormatter));
//        System.out.println(LocalDateTime.parse("11:31:43.50", dateFormatter));
        System.out.println(LocalDateTime.parse("2013-10-07 12:13:27.1", dateFormatter));
    }

    @Test
    public void instantTest() {
        LocalDateTime localDateTime = Instant.parse("2018-05-23T23:18:31.0Z")                // Parse this String in standard ISO 8601 format as a `Instant`, a point on the timeline in UTC. The `Z` means UTC.
                .atOffset(ZoneOffset.UTC)                                // Change from `Instant` to the more flexible `OffsetDateTime`.
                .toLocalDateTime();// Returns a `String` object.
        System.out.println(localDateTime.toString());
    }
}

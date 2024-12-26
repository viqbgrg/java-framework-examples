package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonLongTest {
    @Test
    void test() {
        String json = " [\n" +
                "        {\n" +
                "            \"id\": \"823143171608317428\",\n" +
                "            \"name\": \"2024.hdr.2160p.web.h265.mkv\",\n" +
                "            \"size\": 21450125247,\n" +
                "            \"md5\": \"470E11E6D16B06C0445FF51AD0C7D747\",\n" +
                "            \"shareId\": 12309113973616\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"923143171608317431\",\n" +
                "            \"name\": \"2024.hdr.2160p.web.h265.ass\",\n" +
                "            \"size\": 787090,\n" +
                "            \"md5\": \"10A81F76665862DD38930885CA868338\",\n" +
                "            \"shareId\": 12309113973616\n" +
                "        }\n" +
                "    ]";
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Share189File>> typeRef = new TypeReference<>() {
        };

        try {
            List<Share189File> share189Files = objectMapper.readValue(json, typeRef);
            System.out.println(share189Files.get(0).getShareId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Data
    public static class Share189File {
        private String id;
        private String name;
        private long size;
        private String md5;
        private long shareId;

    }

}

package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayTest {

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
    }
    @Test
    void listToString() throws JsonProcessingException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);
    }

    @Test
    void stringToList() throws JsonProcessingException {
        String listString = "[1,100]";
        TypeReference<List<Integer>> typeReference = new TypeReference<>() {
        };
//        List<Integer> list = objectMapper.convertValue(listString, typeReference);
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Integer.class);
        List<Integer> list = objectMapper.readValue(listString, List.class);
//        List<Integer> list = objectMapper.readValue(listString, listType);
        System.out.println(list);
    }
}

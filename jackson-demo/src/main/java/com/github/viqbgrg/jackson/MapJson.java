package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.Map;

/**
 * @author hhj
 */
public class MapJson extends JsonBaseTest{
    @Test
    void mapTest() throws JsonProcessingException {
        String jsonString = "{\n" +
                "    \"name\": \"0.00\",\n" +
                "    \"score\": {\n" +
                "        \"f0SESclJfcI0tsvmHX3j\": \"工业\",\n" +
                "        \"f7tJqsLFA6YkPpVQVC8q\": \"地中海\",\n" +
                "        \"fDRbiFYi7rz7C7LCSuPG\": \"美式\",\n" +
                "        \"fg9D7Vd1TX9RhWFADv7k\": \"简欧\",\n" +
                "        \"fICO6roiPQ7bssXiJ24U\": \"现代简约\",\n" +
                "        \"fpe28wKNBoYP2xGUt3tI\": \"轻奢\",\n" +
                "        \"fPIJb9BuQD54rVtSa7Jf\": \"混搭\",\n" +
                "        \"fSeAbRYOjOUmRV4gOD72\": \"欧式\",\n" +
                "        \"ftJLZGUjKgmRsnkBEwWl\": \"北欧\",\n" +
                "        \"fw6yGa0W5ijTumaVgxXo\": \"新中式\",\n" +
                "        \"fzHR1Iq40h182OwX2z9V\": \"日式\"\n" +
                "    }\n" +
                "}";
        Student student = objectMapper.readValue(jsonString, Student.class);
        assertThat(student.getScore()).isNotNull();
    }
    @Data
    public static class Student{
        private String name;
        private Map<String, String> score;
    }
}

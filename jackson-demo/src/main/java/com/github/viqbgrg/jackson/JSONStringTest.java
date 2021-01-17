package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 测试json Object 创建生成字符串
 * @author viqbg
 */
@Slf4j
public class JSONStringTest {

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void jsonObjectTest() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "xiaoming");
        objectNode.put("age", 1);
        log.info(objectNode.asText());
        log.info(objectNode.toString());
        log.info(objectNode.textValue());
        log.info(objectNode.toPrettyString());
    }

    @Test
    void jsonArrayTest() {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add("23");
        arrayNode.add("100");
        log.info(arrayNode.toString());
    }
}

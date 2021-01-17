package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
//        logger.info(objectNode.asText());
        log.info(objectNode.asText());
        log.info(objectNode.toString());
        log.info(objectNode.textValue());
        log.info(objectNode.toPrettyString());
    }
}

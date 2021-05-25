package com.github.viqbgrg.base;

import org.apache.ibatis.io.Resources;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

/**
 * @author bing
 */
public class MybatisResourceTest {
    @Test
    void resourceTest() throws IOException {
        URL resourceURL = Resources.getResourceURL("data.sql");
        System.out.println(resourceURL.getPath());
    }
}

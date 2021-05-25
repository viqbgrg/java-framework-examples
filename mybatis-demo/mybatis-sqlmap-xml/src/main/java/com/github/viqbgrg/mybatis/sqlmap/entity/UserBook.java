package com.github.viqbgrg.mybatis.sqlmap.entity;

import lombok.Data;

import java.util.List;

/**
 * @author bing
 */
@Data
public class UserBook {
    private int id;
    private List<Book> book;

    @Data
    public static class Book {
        private String name;
        private String tag;
    }
}

package com.github.viqbgrg;

import lombok.Data;

/**
 * @author viqbgrg
 */
@Data
public class Book {
    private String bookName;

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}

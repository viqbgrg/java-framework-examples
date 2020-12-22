package com.github.viqbgrg.springbootmybatistodo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ToDo {
    public ToDo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    public ToDo(Long id, String text, boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    private long id;
    private String text;
    private boolean completed;
}

package com.github.viqbgrg.springbootmybatistodo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private ToDoMapper toDoMapper;

    public ToDoService(ToDoMapper toDoMapper) {
        this.toDoMapper = toDoMapper;
    }

    public List<ToDo> findAll() {
        return new ArrayList<>();
    }
}

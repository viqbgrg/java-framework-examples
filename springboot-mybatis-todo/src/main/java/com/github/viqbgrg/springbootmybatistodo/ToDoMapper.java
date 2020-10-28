package com.github.viqbgrg.springbootmybatistodo;

import org.springframework.stereotype.Repository;

@Repository
public interface ToDoMapper {
    void save(ToDo todoSample);
}

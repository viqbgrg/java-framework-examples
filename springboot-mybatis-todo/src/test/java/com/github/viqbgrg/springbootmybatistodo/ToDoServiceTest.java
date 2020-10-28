package com.github.viqbgrg.springbootmybatistodo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ToDoServiceTest {
    @MockBean
    private ToDoMapper toDoMapper;
    @Test
    void findAll() {
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        toDoMapper.save(todoSample);
        ToDoService toDoService = new ToDoService(toDoMapper);

        List<ToDo> toDoList = toDoService.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size()-1);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(todoSample.getId(), lastToDo.getId());
    }
}
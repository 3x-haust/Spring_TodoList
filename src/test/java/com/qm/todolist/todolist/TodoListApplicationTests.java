package com.qm.todolist.todolist;

import com.qm.todolist.todolist.service.TodoService;
import com.qm.todolist.todolist.service.TodoServiceImpl;
import com.qm.todolist.todolist.util.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void saveAndGetPhoneInfo() throws Exception {
    }

}

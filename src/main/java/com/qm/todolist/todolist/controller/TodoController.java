package com.qm.todolist.todolist.controller;

import com.qm.todolist.todolist.service.TodoService;
import com.qm.todolist.todolist.util.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/insertTodo")
    public String insertTodo(@RequestParam String todo, Boolean check) throws ExecutionException, InterruptedException {
        Todo todo1 = new Todo();
        todo1.setTodo(todo);
        todo1.setCheck(check);

        return todoService.insertTodo(todo1);
    }

    @GetMapping("/getTodoDetail")
    public Todo getTodoDetail(@RequestParam String todo) throws ExecutionException, InterruptedException {
        return todoService.getTodoDetail(todo);
    }

    @GetMapping("/updateTodo")
    public String updateTodo(@RequestParam String todo, Boolean check) throws ExecutionException, InterruptedException {
        Todo todo1 = new Todo();

        todo1.setCheck(check);
        todo1.setTodo(todo);

        return todoService.updateTodo(todo1);
    }

    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam String todo) {
        return todoService.deleteTodo(todo);
    }

    @GetMapping("/getTodoList")
    public Map<String, Boolean> getTodoList() throws ExecutionException, InterruptedException {
        return todoService.getTodoList();
    }
}

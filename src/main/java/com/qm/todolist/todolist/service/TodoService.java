package com.qm.todolist.todolist.service;

import com.qm.todolist.todolist.util.Todo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface TodoService {
    String insertTodo(Todo Todo) throws ExecutionException, InterruptedException;
    Todo getTodoDetail(String todo) throws ExecutionException, InterruptedException;
    String updateTodo(Todo Todo) throws ExecutionException, InterruptedException;
    String deleteTodo(String todo);
    Map<String, Boolean> getTodoList() throws ExecutionException, InterruptedException;
}

package com.qm.todolist.todolist.service;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.qm.todolist.todolist.util.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class TodoServiceImpl implements TodoService {

    public static final String COLLECTION_NAME = "todo";

    @Override
    public String insertTodo(Todo todo) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture =
                firestore.collection(COLLECTION_NAME).document(todo.getTodo()).set(todo);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Todo getTodoDetail(String name) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =
                firestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        Todo todo = null;
        if(documentSnapshot.exists()){
            todo = documentSnapshot.toObject(Todo.class);
            return todo;
        }
        else{
            return null;
        }
    }

    @Override
    public String updateTodo(Todo todo) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture
                = firestore.collection(COLLECTION_NAME).document(todo.getTodo()).set(todo);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteTodo(String todo) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture
                = firestore.collection(COLLECTION_NAME).document(todo).delete();
        return "Document id: " + todo + " delete";
    }

    @Override
    public Map<String, Boolean> getTodoList() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);
        ApiFuture<QuerySnapshot> querySnapshot = collectionReference.get();

        Map<String, Boolean> list = new HashMap<>();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            Todo todo = document.toObject(Todo.class);

            list.put(todo.getTodo(), todo.getCheck());
        }

        return list;
    }
}

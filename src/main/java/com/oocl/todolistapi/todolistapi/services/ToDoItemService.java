package com.oocl.todolistapi.todolistapi.services;

import com.oocl.todolistapi.todolistapi.models.ToDoItem;
import com.oocl.todolistapi.todolistapi.repositories.ToDoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {
    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public List<ToDoItem> getAllToDoItems() {
        return toDoItemRepository.findAll();
    }
}

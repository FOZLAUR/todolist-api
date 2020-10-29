package com.oocl.todolistapi.todolistapi.controllers;

import com.oocl.todolistapi.todolistapi.entity.ToDoItem;
import com.oocl.todolistapi.todolistapi.services.ToDoItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/todos")
public class ToDoItemController {
    private ToDoItemService toDoItemService;

    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    //CREATE
    @PostMapping()
    public ToDoItem createToDoItem(ToDoItem toDoItem){
        return toDoItemService.createToDoItem(toDoItem);
    }

    // READ
    @GetMapping()
    public List<ToDoItem> getAllToDoItems(){
        return toDoItemService.getAllToDoItems();
    }

    // UPDATE
    @PutMapping("{taskId}")
    public ToDoItem updateToDoItem(int taskId){
        return toDoItemService.updateToDoItem(taskId);
    }
    
    // D

}

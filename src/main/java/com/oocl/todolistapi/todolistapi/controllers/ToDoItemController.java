package com.oocl.todolistapi.todolistapi.controllers;

import com.oocl.todolistapi.todolistapi.dto.ToDoItemMapper;
import com.oocl.todolistapi.todolistapi.dto.ToDoItemResponse;
import com.oocl.todolistapi.todolistapi.entity.ToDoItem;
import com.oocl.todolistapi.todolistapi.services.ToDoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/todos")
public class ToDoItemController {
    private final ToDoItemService toDoItemService;
    private final ToDoItemMapper toDoItemMapper;

    public ToDoItemController(ToDoItemService toDoItemService, ToDoItemMapper toDoItemMapper) {
        this.toDoItemService = toDoItemService;
        this.toDoItemMapper = toDoItemMapper;
    }

    //CREATE
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItemResponse createToDoItem(@RequestBody ToDoItem newToDoItem){
        //ToDoItem toDoItem = toDoItemMapper.toEntity(request);
        return toDoItemMapper.toResponse(toDoItemService.createToDoItem(newToDoItem));
    }
    // READ
    @GetMapping()
    public List<ToDoItemResponse> getAllToDoItems() {
        List<ToDoItem> toDoItemList = toDoItemService.getAllToDoItems();
        return toDoItemList.stream().map(toDoItemMapper::toResponse).collect(Collectors.toList());
    }

    // UPDATE
    @PutMapping("/{taskId}")
    public ToDoItemResponse updateToDoItem(@PathVariable int taskId){
        ToDoItem updatedToDoItem = toDoItemService.updateToDoItem(taskId);
        return toDoItemMapper.toResponse(updatedToDoItem);
    }

    // DELETE
    @DeleteMapping("/{taskId}")
    public void deleteToDoItem(@PathVariable int taskId){
        toDoItemService.deleteToDoItem(taskId);
    }
}

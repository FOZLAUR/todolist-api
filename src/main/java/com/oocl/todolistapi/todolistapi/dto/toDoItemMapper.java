package com.oocl.todolistapi.todolistapi.dto;

import com.oocl.todolistapi.todolistapi.entity.ToDoItem;
import org.springframework.stereotype.Component;

@Component
public class toDoItemMapper {
    public ToDoItemResponse toResponse(ToDoItem toDoItem){
        ToDoItemResponse toDoItemResponse = new ToDoItemResponse();
        toDoItemResponse.setToDoId(toDoItem.getToDoId());
        toDoItemResponse.setText(toDoItem.getText());
        toDoItemResponse.setDone(toDoItem.isDone());

        return toDoItemResponse;
    }

    public ToDoItem toEntity(ToDoItemRequest toDoItemRequest){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setText(toDoItemRequest.getText());

        return toDoItem;
    }
}

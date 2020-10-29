package com.oocl.todolistapi.todolistapi.dto;

public class ToDoItemRequest {
    private String text;

    public ToDoItemRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

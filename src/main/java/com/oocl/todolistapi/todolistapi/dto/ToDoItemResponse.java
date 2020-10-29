package com.oocl.todolistapi.todolistapi.dto;

public class ToDoItemResponse {
    private int toDoId;
    private String text;
    private boolean isDone;

    public ToDoItemResponse() { }

    public ToDoItemResponse(int toDoId, String text, boolean isDone) {
        this.toDoId = toDoId;
        this.text = text;
        this.isDone = isDone;
    }

    public int getToDoId() {
        return toDoId;
    }

    public void setToDoId(int toDoId) {
        this.toDoId = toDoId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

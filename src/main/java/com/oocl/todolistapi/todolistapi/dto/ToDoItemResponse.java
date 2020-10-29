package com.oocl.todolistapi.todolistapi.dto;

public class ToDoItemResponse {
    private int id;
    private String text;
    private boolean done;

    public ToDoItemResponse() { }

    public ToDoItemResponse(int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

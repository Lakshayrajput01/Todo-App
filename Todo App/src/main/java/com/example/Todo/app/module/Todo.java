package com.example.Todo.app.module;

public class Todo {
    private String id;
    private String Name;
    private boolean Status;

    public Todo() {
    }

    public Todo(String id, String name, boolean status) {
        this.id = id;
        Name = name;
        Status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

}

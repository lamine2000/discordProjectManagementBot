package com.lamine.model;

import org.bson.types.ObjectId;

import java.util.List;

public class Task {
    private String name, description;
    private ObjectId user;

    public Task(String name, String description, ObjectId user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Task() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectId getUser() {
        return user;
    }

    public void setUser(ObjectId user) {
        this.user = user;
    }
}

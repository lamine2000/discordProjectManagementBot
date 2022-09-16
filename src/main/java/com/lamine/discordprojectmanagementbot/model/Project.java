package com.lamine.model;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

public class Project {
    private String name, description;

    private List<ObjectId> tasks;

    public Project(String name, String description, List<ObjectId> tasks) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project(String name) {
        this.name = name;
    }

    public Project() {

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

    public List<ObjectId> getTasks() {
        return tasks;
    }

    public void setTasks(List<ObjectId> tasks) {
        this.tasks = tasks;
    }
}

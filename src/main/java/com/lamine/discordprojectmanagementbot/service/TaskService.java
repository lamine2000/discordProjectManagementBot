package com.lamine.discordprojectmanagementbot.service;

import com.lamine.discordprojectmanagementbot.model.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);

    List<Task> findAllByProjectId(String projectId);

    Task findTaskByUserId(String userId);

    List<Task> findAllTasksByProjectId(String projectId);

    Task markTaskAsDone(String taskName);

    List<Task> findAllAssignedTasks(String userId);

    List<Task> findAll();
}

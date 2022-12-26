package com.lamine.discordprojectmanagementbot.service.impl;

import com.lamine.discordprojectmanagementbot.model.Task;
import com.lamine.discordprojectmanagementbot.repository.TaskRepository;
import com.lamine.discordprojectmanagementbot.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}

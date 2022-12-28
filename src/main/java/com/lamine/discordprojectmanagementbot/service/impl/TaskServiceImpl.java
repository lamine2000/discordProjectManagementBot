package com.lamine.discordprojectmanagementbot.service.impl;

import com.lamine.discordprojectmanagementbot.model.Task;
import com.lamine.discordprojectmanagementbot.repository.TaskRepository;
import com.lamine.discordprojectmanagementbot.repository.UserRepository;
import com.lamine.discordprojectmanagementbot.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                           UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllByProjectId(String projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }

    @Override
    public Task findTaskByUserId(String userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public List<Task> findAllTasksByProjectId(String projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }

    @Override
    public Task markTaskAsDone(String taskName) {
        Task task = taskRepository.findByName(taskName)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setIsCompleted(true);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllAssignedTasks(String userdId) {
        return taskRepository.findAllByUserId(userdId);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}

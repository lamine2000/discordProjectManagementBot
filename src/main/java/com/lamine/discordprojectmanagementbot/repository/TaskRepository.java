package com.lamine.discordprojectmanagementbot.repository;

import com.lamine.discordprojectmanagementbot.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findAllByProjectId(String projectId);

    Task findByUserId(String userId);

    Optional<Task> findByName(String taskName);

    List<Task> findAllByUserId(String userdId);
}

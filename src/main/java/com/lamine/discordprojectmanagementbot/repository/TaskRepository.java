package com.lamine.discordprojectmanagementbot.repository;

import com.lamine.discordprojectmanagementbot.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}

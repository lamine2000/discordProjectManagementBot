package com.lamine.discordprojectmanagementbot.repository;

import com.lamine.discordprojectmanagementbot.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}

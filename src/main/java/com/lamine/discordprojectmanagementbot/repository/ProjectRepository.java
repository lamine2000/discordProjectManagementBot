package com.lamine.discordprojectmanagementbot.repository;

import com.lamine.discordprojectmanagementbot.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {
   @Query("{ 'name' : ?0 }")
   Optional<Project> findByName(String name);

   //find all projects
    List<Project> findAll();
}

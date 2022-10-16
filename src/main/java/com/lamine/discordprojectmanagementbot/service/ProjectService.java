package com.lamine.discordprojectmanagementbot.service;

import com.lamine.discordprojectmanagementbot.model.Project;

import java.util.List;

public interface ProjectService {

    //function to create a project
    Project saveProject(Project project);

    Project findProjectById(String id);

    Project findProjectByName(String name);

    //function to find all projects
    List<Project> findAll();
}

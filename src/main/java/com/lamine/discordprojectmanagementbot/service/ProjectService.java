package com.lamine.discordprojectmanagementbot.service;

import com.lamine.discordprojectmanagementbot.model.Project;

public interface ProjectService {

    //function to create a project
    Project saveProject(Project project);
}

package com.lamine.discordprojectmanagementbot.service.impl;

import com.lamine.discordprojectmanagementbot.model.Project;
import com.lamine.discordprojectmanagementbot.repository.ProjectRepository;
import com.lamine.discordprojectmanagementbot.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project findProjectByName(String name) {
        return projectRepository.findByName(name).orElse(null);
    }


}

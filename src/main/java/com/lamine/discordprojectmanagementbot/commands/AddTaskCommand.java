package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.model.Task;
import com.lamine.discordprojectmanagementbot.service.ProjectService;
import com.lamine.discordprojectmanagementbot.service.TaskService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddTaskCommand {
    final TaskService taskService;
    final ProjectService projectService;

    public AddTaskCommand(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    public List<Command.Choice> getProjectChoices() {
        return this.projectService.findAll().stream()
                .map(project -> new Command.Choice(project.getName(), project.getName()))
                .collect(Collectors.toList());
    }

    public void execute(SlashCommandInteractionEvent event) {
        final String taskName = event.getOption("name").getAsString();
        final String taskDescription = event.getOption("description").getAsString();
        final String guildId = event.getGuild().getId();
        final String projectName = event.getOption("project").getAsString();
        final String projectId = projectService
                .findProjectByName(projectName)
                .getId();

        event
                .reply(String.format("Adding task %s to project %s...", taskName, projectName))
                .queue(
                        response -> {
                            taskService.saveTask(
                                    new Task(
                                            guildId,
                                            projectId,
                                            taskName,
                                            taskDescription,
                                            false
                                    )
                            );

                            response.editOriginal(String.format("Task %s added successfully to project %s", taskName, projectName)).queue();
                        }
                );
    }
}

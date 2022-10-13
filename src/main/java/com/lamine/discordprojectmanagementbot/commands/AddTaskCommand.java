package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.model.Task;
import com.lamine.discordprojectmanagementbot.service.ProjectService;
import com.lamine.discordprojectmanagementbot.service.TaskService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class AddTaskCommand {
    final TaskService taskService;
    final ProjectService projectService;

    public AddTaskCommand(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
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
                .getChannel()
                .sendMessage(String.format("Adding task %s to project %s...", taskName, projectName))
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

                            response.editMessageFormat("Task %s added to project %s successfully", taskName, projectName).queue();
                        }
                );
    }
}

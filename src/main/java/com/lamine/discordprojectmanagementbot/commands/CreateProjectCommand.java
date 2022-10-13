package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.model.Project;
import com.lamine.discordprojectmanagementbot.service.ProjectService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectCommand {

    final ProjectService projectService;

    public CreateProjectCommand(ProjectService projectService) {
        this.projectService = projectService;
    }

    public void execute(SlashCommandInteractionEvent event) {
        final String projectName = event.getOption("name").getAsString();
        final String projectDescription = event.getOption("description").getAsString();
        final String guildId = event.getGuild().getId();

        event
                .getChannel()
                .sendMessage(String.format("Creating project %s with description %s...", projectName, projectDescription))
                .queue(
                        response -> {
                            projectService.saveProject(
                                    new Project(
                                        guildId,
                                        projectName,
                                        projectDescription,
                                        false)
                            );

                            response.editMessageFormat("Project %s created successfully", projectName).queue();
                        }
                );
    }
}

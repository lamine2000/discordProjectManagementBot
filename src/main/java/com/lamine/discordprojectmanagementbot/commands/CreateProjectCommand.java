package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.model.Project;
import com.lamine.discordprojectmanagementbot.service.ProjectService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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
                .reply(String.format("Creating project %s with description %s...", projectName, projectDescription))
                .queue(
                        response -> {
                            projectService.saveProject(
                                    new Project(
                                        guildId,
                                        projectName,
                                        projectDescription,
                                        false)
                            );

                            response.editOriginal(String.format("Project %s created successfully", projectName)).queue(
                                    r -> {
                                       event.getGuild().upsertCommand(Commands.slash("addtask", "Add a task to a project")
                                               .addOption(OptionType.STRING, "name", "The name of the task", true)
                                               .addOption(OptionType.STRING, "description", "The description of the task", true)
                                               .addOptions(new OptionData(OptionType.STRING, "project", "The name of the project", true)
                                                       .addChoices(this.projectService.findAll().stream()
                                                               .map(project -> new Command.Choice(project.getName(), project.getName()))
                                                               .collect(Collectors.toList())))).queue();
                                    }
                            );
                        }
                );
    }
}

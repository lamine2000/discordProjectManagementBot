package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.service.TaskService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.springframework.stereotype.Component;
import java.util.List;

import java.util.stream.Collectors;

@Component
public class MarkTaskAsDoneCommand {
    private final TaskService taskService;

    public MarkTaskAsDoneCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Command.Choice> getAllAssignedTasks(String userId) {
        return this.taskService.findAllAssignedTasks(userId).stream()
                .map(task -> new Command.Choice(task.getName(), task.getName()))
                .collect(Collectors.toList());
    }

    //List all tasks
    public List<Command.Choice> getAllTasks() {
        return this.taskService.findAll().stream()
                .map(task -> new Command.Choice(task.getName(), task.getName()))
                .collect(Collectors.toList());
    }

    public void execute(SlashCommandInteractionEvent event) {
        final String taskName = event.getOption("task").getAsString();
        taskService.markTaskAsDone(taskName);
    }
}

package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.model.Project;
import com.lamine.discordprojectmanagementbot.model.Task;
import com.lamine.discordprojectmanagementbot.model.User;
import com.lamine.discordprojectmanagementbot.service.ProjectService;
import com.lamine.discordprojectmanagementbot.service.TaskService;
import com.lamine.discordprojectmanagementbot.service.UserService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignTaskToUserCommand {
    final TaskService taskService;
    final ProjectService projectService;
    final UserService userService;

    public AssignTaskToUserCommand(
            TaskService taskService,
            ProjectService projectService,
            UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    public List<Command.Choice> getAllUsers() {
        return userService.findAll().stream()
                .map(user -> new Command.Choice(user.getId(), user.getId()))
                .collect(Collectors.toList());
    }

    //get all users that have not been assigned to a task in a given project
    public List<Command.Choice> getAvailableUsers(String projectName) {
        final Project project = projectService.findProjectByName(projectName);
        final List<User> users = userService.findAll();
        final List<Task> tasks = taskService.findAllTasksByProjectId(project.getId());

        return users.stream()
                .filter(user -> tasks.stream().noneMatch(task -> task.getUserId().equals(user.getId())))
                .map(user -> new Command.Choice(user.getId(), user.getId()))
                .collect(Collectors.toList());
    }

    //get all the projects that have at least one unassigned task
    public List<Command.Choice> getAllAvailableProjects(){
        return projectService.findAll().stream()
                .filter(project -> taskService
                        .findAllByProjectId(project.getId())
                        .stream()
                        .anyMatch(task -> task.getUserId().isEmpty()))
                .map(project -> new Command.Choice(project.getName(), project.getName()))
                .collect(Collectors.toList());
    }

    //get all the tasks that are unassigned for a given project
    /**
     * Returns a List of all the tasks that are unassigned for a given project
     *
     * @param projectId
     * @return a list of task names
     */
    public List<String> getAllAvailableTasksByProjectId(String projectId){
        return taskService.findAllByProjectId(projectId).stream()
                .filter(task -> task.getUserId().isEmpty())
                .map(Task::getName)
                .collect(Collectors.toList());
    }

    public void execute(SlashCommandInteractionEvent event) {

    }
}

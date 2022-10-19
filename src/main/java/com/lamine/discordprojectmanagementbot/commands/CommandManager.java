package com.lamine.discordprojectmanagementbot.commands;

import com.lamine.discordprojectmanagementbot.service.ProjectService;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommandManager extends ListenerAdapter {
    private final CreateProjectCommand createProjectCommand;
    private final AddTaskCommand addTaskCommand;
    public CommandManager(CreateProjectCommand createProjectCommand, AddTaskCommand addTaskCommand, ProjectService projectService) {
        this.createProjectCommand = createProjectCommand;
        this.addTaskCommand = addTaskCommand;
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        //delete all commands
        //event.getJDA().updateCommands().queue();

        List<CommandData> commandsData = new ArrayList<>();

        /*register all commands here*/
        //ping command
        commandsData.add(Commands.slash("ping", "Ping the bot"));

        //create project command
        commandsData.add(Commands.slash("createproject", "Create a project")
                .addOption(OptionType.STRING, "name", "The name of the project", true)
                .addOption(OptionType.STRING, "description", "The description of the project", true));

        //add task command
        commandsData.add(Commands.slash("addtask", "Add a task to a project")
                .addOption(OptionType.STRING, "name", "The name of the task", true)
                .addOption(OptionType.STRING, "description", "The description of the task", true)
                .addOptions(new OptionData(OptionType.STRING, "project", "The name of the project", true)
                        .addChoices(addTaskCommand.getProjectChoices()))); //these choices are dynamic and will be updated when a new project is created
        //update commands
        event.getGuild().updateCommands().addCommands(commandsData).queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if(event.getGuild() == null){
            event.reply("This bot only works in guilds.").queue();
            return;
        }
         //switch case
        switch(event.getName().toLowerCase()){
            case "ping":
                PingCommand.execute(event);
                break;
            case "createproject":
                createProjectCommand.execute(event);
                break;
            case "addtask":
                addTaskCommand.execute(event);
                break;
            /*case "delete":
                new DeleteCommand.execute(event);
                break;
            case "list":
                new ListCommand.execute(event);
                break;
            case "complete":
                new CompleteCommand.execute(event);
                break;
            case "uncomplete":
                new UncompleteCommand.execute(event);
                break;
            case "add":
                new AddCommand.execute(event);
                break;
            case "remove":
                new RemoveCommand.execute(event);
                break;
            case "info":
                new InfoCommand.execute(event);
                break;
            case "invite":
                new InviteCommand.execute(event);
                break;
            case "ping":
                new PingCommand.execute(event);
                break;
            case "about":
                new AboutCommand.execute(event);
                break;*/
            default:
                event.reply("Are you sure this is not a typo ?").setEphemeral(true).queue();
        }
    }
}



package com.lamine.discordprojectmanagementbot.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandsData = new ArrayList<>();

        //register all commands here
        //ping command
        commandsData.add(Commands.slash("ping", "Ping the bot"));

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
        switch(event.getName()){
            case "ping":
                PingCommand.execute(event);
                break;
            /*case "create":
                new CreateCommand.execute(event);
                break;
            case "delete":
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


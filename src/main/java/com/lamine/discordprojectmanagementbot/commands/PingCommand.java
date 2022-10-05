package com.lamine.discordprojectmanagementbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.time.temporal.ChronoUnit;
public class PingCommand {
    public static void execute(SlashCommandInteractionEvent event) {
        event.getChannel().sendMessage("Pong !").queue(response -> {
            long ping = event.getTimeCreated().until(response.getTimeCreated(), ChronoUnit.MILLIS);
            response.editMessage("Ping: " + ping + "ms | Websocket: " + event.getJDA().getGatewayPing() + "ms").queue();
        });
    }
}

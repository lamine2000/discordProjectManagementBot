package com.lamine.discordprojectmanagementbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class PingCommand {
    public static void execute(SlashCommandInteractionEvent event) {
        event.reply("Pong !").queue(response -> {
            long ping = event.getTimeCreated().until(OffsetDateTime.now(), ChronoUnit.MILLIS);
            response.editOriginal(String.format("Ping: %s ms | Websocket: %s ms", ping, event.getJDA().getGatewayPing())).queue();
        });
    }
}

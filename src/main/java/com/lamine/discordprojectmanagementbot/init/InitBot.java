package com.lamine.discordprojectmanagementbot.init;

import com.lamine.discordprojectmanagementbot.commands.CommandManager;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;
import java.util.List;

@Component
public class InitBot implements ApplicationListener<ApplicationReadyEvent> {
    private final CommandManager commandManager;

    public InitBot(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        final String token = Dotenv
                .configure()
                .load()
                .get("TOKEN");

        final List<GatewayIntent> intents = List.of(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT);
        try {
            JDABuilder
                    .create(token, intents)
                    .disableCache(List.of(
                            CacheFlag.ACTIVITY,
                            CacheFlag.VOICE_STATE,
                            CacheFlag.EMOJI,
                            CacheFlag.STICKER,
                            CacheFlag.CLIENT_STATUS,
                            CacheFlag.ONLINE_STATUS
                    ))
                    .addEventListeners(commandManager)
                    .setActivity(Activity.listening("your commands ;)"))
                    .build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
    }
}

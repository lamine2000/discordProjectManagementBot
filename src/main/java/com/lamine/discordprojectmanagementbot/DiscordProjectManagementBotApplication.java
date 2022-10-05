package com.lamine.discordprojectmanagementbot;

import com.lamine.discordprojectmanagementbot.commands.CommandManager;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.security.auth.login.LoginException;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DiscordProjectManagementBotApplication {

    private static Dotenv config;
    public static void main(String[] args) throws LoginException {
        SpringApplication.run(DiscordProjectManagementBotApplication.class, args);
        // We only need 2 intents in this bot. We only respond to messages in guilds and private channels.
        // All other events will be disabled.
        /*
        config = Dotenv.configure().load();
        final String token = config.get("TOKEN");
        */
        final String token = System.getenv("TOKEN");
        final List<GatewayIntent> intents = List.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES);
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
                .addEventListeners(new CommandManager())
                .setActivity(Activity.listening("your commands ;)"))
                .build();
                //TODO: créer un fichier pour chaque commande
    }

    public static Dotenv getConfig() {
        return config;
    }

    public static void setConfig(Dotenv config) {
        DiscordProjectManagementBotApplication.config = config;
    }
}

package com.lamine.discordprojectmanagementbot;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.security.auth.login.LoginException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DiscordProjectManagementBotApplication {
    private static Dotenv config;
    public static void main(String[] args) throws LoginException {
        SpringApplication.run(DiscordProjectManagementBotApplication.class, args);
        // We only need 2 intents in this bot. We only respond to messages in guilds and private channels.
        // All other events will be disabled.
    }

    public static Dotenv getConfig() {
        return config;
    }

    public static void setConfig(Dotenv config) {
        DiscordProjectManagementBotApplication.config = config;
    }
}

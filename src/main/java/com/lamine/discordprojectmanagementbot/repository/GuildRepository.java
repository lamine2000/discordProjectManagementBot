package com.lamine.discordprojectmanagementbot.repository;

import com.lamine.discordprojectmanagementbot.model.Guild;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuildRepository extends MongoRepository<Guild, String> {
}

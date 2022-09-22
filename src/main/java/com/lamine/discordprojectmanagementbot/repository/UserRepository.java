package com.lamine.discordprojectmanagementbot.repository;

import com.lamine.discordprojectmanagementbot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

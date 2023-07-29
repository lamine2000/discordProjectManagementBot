package com.lamine.discordprojectmanagementbot.service;

import com.lamine.discordprojectmanagementbot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}

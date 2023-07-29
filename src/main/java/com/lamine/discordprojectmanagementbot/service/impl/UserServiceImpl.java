package com.lamine.discordprojectmanagementbot.service.impl;

import com.lamine.discordprojectmanagementbot.model.User;
import com.lamine.discordprojectmanagementbot.repository.UserRepository;
import com.lamine.discordprojectmanagementbot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}

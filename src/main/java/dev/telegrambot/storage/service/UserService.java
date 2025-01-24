package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.user.User;

public interface UserService {
    User createUser(User user);
    User getUserByEmail(String email);
}

package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.UserAlreadyExist;
import dev.telegrambot.storage.domain.UserNotFoundException;
import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.repository.UserRepository;
import dev.telegrambot.storage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        try {
            User savedUser = getUserByEmail(user.getEmail());
            throw new UserAlreadyExist(String.format("User with email: %s doesn't exist", user.getEmail()), savedUser);
        }
        catch (UserNotFoundException e) {
            return userRepository.save(user);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException(String.format("User with email: %s doesn't exist", email))
        );
    }
}

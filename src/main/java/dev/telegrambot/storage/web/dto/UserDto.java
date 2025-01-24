package dev.telegrambot.storage.web.dto;

import dev.telegrambot.storage.domain.user.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String name;
    private String lastName;
    private String phone;
    private String city;
    private String email;
    private Roles role;
    private Date registrationDate;
}

package io.github.jvictor12.AuthenticationAPIUsers.dto;

import io.github.jvictor12.AuthenticationAPIUsers.entity.User;
import io.github.jvictor12.AuthenticationAPIUsers.entity.UserRole;

import java.io.Serializable;

public record UserDTO(
        String login,
        UserRole userRole
) implements Serializable {

    public UserDTO (User user) {
        this (
                user.getLogin(),
                user.getUserRole()
        );
    }
}

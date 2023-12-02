package io.github.jvictor12.AuthenticationAPIUsers.dto;

import io.github.jvictor12.AuthenticationAPIUsers.entity.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}

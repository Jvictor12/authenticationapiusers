package io.github.jvictor12.AuthenticationAPIUsers.infra.security;

import io.github.jvictor12.AuthenticationAPIUsers.entity.User;
import io.github.jvictor12.AuthenticationAPIUsers.entity.UserRole;
import io.github.jvictor12.AuthenticationAPIUsers.exception.ObjectNotFoundException;
import io.github.jvictor12.AuthenticationAPIUsers.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationConfig implements CommandLineRunner {

    @Autowired
    AuthorizationService service;

    @Autowired
    private PasswordEncoderConfig encoderConfig;

    @Override
    public void run(String... args) throws Exception {
        checkDefaultUser();
    }

    private void checkDefaultUser() {

        final var user = new User();

        try {
            final var userFinal = service.findByLogin("admin");
            BeanUtils.copyProperties(userFinal, user);
        }catch (ObjectNotFoundException ex) {}

        saveDefaultUser(user);
    }

    private void saveDefaultUser(User user) {

        user.setLogin("admin");
        user.setPassword("admin");
        user.setUserRole(UserRole.valueOf("ADMIN"));

        service.save(user);
    }
}

package io.github.jvictor12.AuthenticationAPIUsers.service;

import io.github.jvictor12.AuthenticationAPIUsers.dto.UserDTO;
import io.github.jvictor12.AuthenticationAPIUsers.entity.User;
import io.github.jvictor12.AuthenticationAPIUsers.exception.ObjectNotFoundException;
import io.github.jvictor12.AuthenticationAPIUsers.exception.ValidationException;
import io.github.jvictor12.AuthenticationAPIUsers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username).orElseThrow(()-> {
            throw new ObjectNotFoundException("Usuario nao encontrado");
        });
    }

    public UserDTO findByLogin(String login){
        final var user = userRepository.findByLogin(login).orElseThrow(()-> {
            throw new ObjectNotFoundException("Usuario nao encontrado");
        });

        return new UserDTO(user);
    }

    public User save(User user) {

        if(user == null){
            throw new ValidationException("Usuario invalido");
        }

        return userRepository.save(encoderPassword(user));
    }

    public User update (User user) {

        if (user == null) {
            throw new ValidationException("Usuario invalido");
        }
        if(!userRepository.existsById(user.getId())){
            throw new ObjectNotFoundException("Usuario nao encontrado");
        }

        return userRepository.save(user);
    }

    private User encoderPassword (User user) {
        if(user.getId() != null) {
            final var user_findById = userRepository.findById(user.getId());

            if (user_findById.isPresent() && !user_findById.get().getPassword().equals(user.getPassword())){
                user.setPassword(encoder.encode(user.getPassword()));
            }
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        return user;
    }

    public List<User> findAll() {
        List<User> usersDTO = userRepository.findAll();

        return usersDTO;
    }
}

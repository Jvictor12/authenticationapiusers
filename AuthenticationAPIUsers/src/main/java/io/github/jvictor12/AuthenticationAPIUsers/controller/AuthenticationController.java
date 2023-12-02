package io.github.jvictor12.AuthenticationAPIUsers.controller;

import io.github.jvictor12.AuthenticationAPIUsers.dto.AuthenticationDTO;
import io.github.jvictor12.AuthenticationAPIUsers.dto.RegisterDTO;
import io.github.jvictor12.AuthenticationAPIUsers.entity.User;
import io.github.jvictor12.AuthenticationAPIUsers.repository.UserRepository;
import io.github.jvictor12.AuthenticationAPIUsers.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.service.findByLogin(data.login()) != null ) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        User user = new User(data.login(), data.password(), data.role());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }
}

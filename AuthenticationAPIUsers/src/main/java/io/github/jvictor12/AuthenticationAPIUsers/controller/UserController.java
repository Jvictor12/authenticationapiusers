package io.github.jvictor12.AuthenticationAPIUsers.controller;

import io.github.jvictor12.AuthenticationAPIUsers.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthorizationService service;


    @GetMapping
    public ResponseEntity findll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}

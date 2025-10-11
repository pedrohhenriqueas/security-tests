package com.example.security_tests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security_tests.models.JwtResponse;
import com.example.security_tests.models.LoginRequestDto;
import com.example.security_tests.service.AuthService;


@RestController
@RequestMapping("/security")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> signin(@RequestBody LoginRequestDto dto) {

        if(dto.getEmail() == null || dto.getPassword() == null)
            return ResponseEntity.badRequest().body("Email ou senhas inválidos");

        JwtResponse jwtResponse = authService.authenticateUser(dto);
        return ResponseEntity.ok(jwtResponse);
    }
}

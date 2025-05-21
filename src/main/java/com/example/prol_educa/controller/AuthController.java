package com.example.prol_educa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prol_educa.models.JwtResponse;
import com.example.prol_educa.models.LoginRequestDto;
import com.example.prol_educa.service.AuthService;


@RestController
@RequestMapping("/edupass")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody LoginRequestDto dto) throws Exception{

        if(dto.getEmail() == null || dto.getPassword() == null)
            return ResponseEntity.badRequest().body("Email ou senhas inválidos");

        JwtResponse jwtResponse = authService.authenticateUser(dto);
        return ResponseEntity.ok(jwtResponse);
    }
}

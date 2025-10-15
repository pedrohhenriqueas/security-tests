package com.example.security_tests.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.security_tests.entities.Customers;
import com.example.security_tests.models.JwtResponse;
import com.example.security_tests.models.LoginRequestDto;
import com.example.security_tests.security.jwt.JwtUtils;
import com.example.security_tests.security.services.UserDetailsImpl;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomersService customersService;
    private final JwtUtils jwtUtils;
    private final LoginAttemptService loginAttemptService;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
            CustomersService customersService, 
            JwtUtils jwtUtils,
            LoginAttemptService loginAttemptService) {
        this.authenticationManager = authenticationManager;
        this.customersService = customersService;
        this.jwtUtils = jwtUtils;
        this.loginAttemptService = loginAttemptService;
    }

    public ResponseEntity<Object> authenticateUser(LoginRequestDto loginRequest, String ip) {

        String username = loginRequest.getName();

        if (loginAttemptService.isBlocked(username)) {
            return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .body("Usuário bloqueado por muitas tentativas. Tente novamente em 3 minutos.");
        }
        
        if(loginAttemptService.isIpBlocked(ip)) {
            return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .body("IP bloqueado por muitas tentativas. Tente novamente amanhã.");
        }
        
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword())
            );

            loginAttemptService.loginSucceeded(username);
            loginAttemptService.loginSucceededByIp(ip);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String jwt = jwtUtils.generateJwtToken(authentication);

            List<String> roles = userDetails.getAuthorities()
                .stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

            int customerId = 0;

            if (roles.contains("ROLE_USER")) {
                Customers customer = customersService.findByEmail(loginRequest.getName());
                if (customer != null) {
                    customerId = customer.getId();
                }
            }

            return ResponseEntity.ok(new JwtResponse(jwt, roles, customerId));
        } catch (Exception ex) {
            loginAttemptService.loginFailed(username);
            loginAttemptService.loginFailedByIp(ip);
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Email ou senha inválidos.");
        }
    }
	
}

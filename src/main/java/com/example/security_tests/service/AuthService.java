package com.example.security_tests.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
            CustomersService customersService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.customersService = customersService;
        this.jwtUtils = jwtUtils;
    }



    public JwtResponse authenticateUser(LoginRequestDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        List<String> roles = userDetails.getAuthorities()
            .stream().map(item -> item.getAuthority())
            .collect(Collectors.toList());

        int customerId = 0;

        if (roles.contains("ROLE_USER")) {
            Customers customer = customersService.findByEmail(dto.getEmail());
            if (customer != null) {
                customerId = customer.getId();
            }
        }
        
        return new JwtResponse(jwt, roles, customerId);
    }
	
}

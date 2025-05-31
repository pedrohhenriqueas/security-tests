package com.example.prol_educa.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Customers;
import com.example.prol_educa.models.JwtResponse;
import com.example.prol_educa.models.LoginRequestDto;
import com.example.prol_educa.security.jwt.JwtUtils;
import com.example.prol_educa.security.services.UserDetailsImpl;

@Service
public class AuthService {

    @Autowired
	PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomersService customersService;

    @Autowired
    private JwtUtils jwtUtils;

    public JwtResponse authenticateUser(LoginRequestDto dto) throws Exception{
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

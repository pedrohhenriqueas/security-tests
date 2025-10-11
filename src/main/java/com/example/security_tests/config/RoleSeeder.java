package com.example.security_tests.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.security_tests.entities.Roles;
import com.example.security_tests.repository.RolesRepository;
import com.example.security_tests.utils.enuns.ERoles;

import jakarta.transaction.Transactional;

public class RoleSeeder {
    
    private final RolesRepository rolesRepository;

    @Autowired
    public RoleSeeder(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }
    
    @Bean
    public CommandLineRunner insertRoles() {
        return args -> {
            insertIfNotExists(ERoles.ROLE_USER);
            insertIfNotExists(ERoles.ROLE_ADMIN);
        };
    }

    @Transactional
    public void insertIfNotExists(ERoles roleType) {
        if (!rolesRepository.existsByType(roleType)) {
            Roles roles = new Roles();
            roles.setType(roleType);
            rolesRepository.save(roles);
        }
    }
}

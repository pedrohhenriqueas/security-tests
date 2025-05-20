package com.example.prol_educa.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prol_educa.entities.Roles;
import com.example.prol_educa.utils.enuns.ERoles;

public interface RolesRepository extends JpaRepository<Roles, Integer>{
    
    Optional<Roles> findByType(ERoles type);
}

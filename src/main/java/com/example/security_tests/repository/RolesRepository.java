package com.example.security_tests.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security_tests.entities.Roles;
import com.example.security_tests.utils.enuns.ERoles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{
    
    Roles findByType(ERoles type);
    boolean existsByType (ERoles type);
}

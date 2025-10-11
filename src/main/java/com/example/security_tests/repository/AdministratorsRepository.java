package com.example.security_tests.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security_tests.entities.Administrators;

@Repository
public interface AdministratorsRepository extends JpaRepository<Administrators, Integer>{

    Administrators findByEmail(String email);
}

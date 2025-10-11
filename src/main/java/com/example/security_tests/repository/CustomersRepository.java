package com.example.security_tests.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security_tests.entities.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{

	Customers findByEmail(String email);

	Customers findByName(String name);

}

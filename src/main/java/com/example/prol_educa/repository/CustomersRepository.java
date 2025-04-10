package com.example.prol_educa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prol_educa.entities.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{

}

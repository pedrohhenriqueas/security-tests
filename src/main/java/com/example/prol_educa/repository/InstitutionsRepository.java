package com.example.prol_educa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prol_educa.entities.Institutions;
import com.example.prol_educa.models.InstitutionsDto;

@Repository
public interface InstitutionsRepository extends JpaRepository<Institutions, Integer>{

}

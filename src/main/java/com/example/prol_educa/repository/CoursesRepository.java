package com.example.prol_educa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.prol_educa.entities.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer>, JpaSpecificationExecutor<Courses>{

	public List<Courses> findByName(String name);
	
	public List<Courses> findByShift(String shift);
	
	public List<Courses> findByPercentageScholarship(BigDecimal percentage_scholarship);
	
	public List<Courses> findByInstitutions_Name(String name);
}

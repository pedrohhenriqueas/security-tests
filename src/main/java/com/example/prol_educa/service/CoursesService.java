package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Courses;
import com.example.prol_educa.entities.Institutions;
import com.example.prol_educa.models.CoursesDto;
import com.example.prol_educa.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	public CoursesRepository repository;
	
	@Autowired
	public InstitutionsService institutionsService;
	
	public void create(CoursesDto dto) throws Exception {
		Institutions institution = institutionsService.findById(dto.getInstitutions_id());
		Courses course = new Courses();
		course.setInstitutions_id(institution);
		course.setName(dto.getName());
		course.setVacancies(dto.getVacancies());
		course.setPercentage_scholarship(dto.getPercentage_scholarship());
		course.setOriginal_value(dto.getOriginal_value());
		course.setDiscount_value(dto.getDiscount_value());
		course.setShift(dto.getShift());
		course.setImage_url(dto.getImage_url());
		course.setDiscount_entrance(dto.getDiscount_entrance());
		course.setStatus(dto.isStatus());
		
		repository.save(course);
	}
	
	public List<Courses> findAll(){
		return repository.findAll();
	}
	
	public Courses findById(Integer id) throws Exception {
		Optional<Courses> course = repository.findById(id);
		if(!course.isPresent()) {
			throw new Exception("Curso não encontrado");
		}
		
		return course.get();
	}
	
	public Courses update(Integer id, CoursesDto dto) throws Exception {
		Institutions institution = institutionsService.findById(dto.getInstitutions_id());
		Courses course = findById(id);
		course.setInstitutions_id(institution);
		course.setName(dto.getName());
		course.setVacancies(dto.getVacancies());
		course.setPercentage_scholarship(dto.getPercentage_scholarship());
		course.setOriginal_value(dto.getOriginal_value());
		course.setDiscount_value(dto.getDiscount_value());
		course.setShift(dto.getShift());
		course.setImage_url(dto.getImage_url());
		course.setDiscount_entrance(dto.getDiscount_entrance());
		course.setStatus(dto.isStatus());
		
		return repository.save(course);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}

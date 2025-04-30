package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Courses;
import com.example.prol_educa.entities.Registrations;
import com.example.prol_educa.entities.ScholarshipHolders;
import com.example.prol_educa.models.RegistrationsDto;
import com.example.prol_educa.repository.RegistrationsRepository;

@Service
public class RegistrationsService {

	@Autowired
	public RegistrationsRepository repository;
	
	@Autowired
	public ScholarshipHoldersService scholarshipHoldersService;
	
	@Autowired
	public CoursesService coursesService;
	
	public void create(RegistrationsDto dto) throws Exception {
		Registrations registrations = new Registrations();
		ScholarshipHolders scholarshipHolder = scholarshipHoldersService.findById(dto.getScholarshipHolderId());
		Courses course = coursesService.findById(dto.getCourseId());
		
		registrations.setRegistrationDate(dto.getRegistrationDate());
		registrations.setStatus(dto.getStatus());
		registrations.setScholarshipHolders(scholarshipHolder);
		registrations.setCourses(course);
		repository.save(registrations);
	}
	
	public List<Registrations> findAll(){
		return repository.findAll();
	}
	
	public Registrations findById(Integer id) throws Exception {
		Optional<Registrations> registration = repository.findById(id);
		if(!registration.isPresent()) {
			throw new Exception("Inscrição não encontrada");
		}
		
		return registration.get();
	}
	
	public Registrations update(Integer id, RegistrationsDto dto) throws Exception {
		Registrations registrations = findById(id);
		ScholarshipHolders scholarshipHolder = scholarshipHoldersService.findById(dto.getScholarshipHolderId());
		Courses course = coursesService.findById(dto.getCourseId());
		
		registrations.setRegistrationDate(dto.getRegistrationDate());
		registrations.setStatus(dto.getStatus());
		registrations.setScholarshipHolders(scholarshipHolder);
		registrations.setCourses(course);
		return repository.save(registrations);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}

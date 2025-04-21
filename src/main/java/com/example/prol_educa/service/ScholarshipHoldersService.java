package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Customers;
import com.example.prol_educa.entities.ScholarshipHolders;
import com.example.prol_educa.models.ScholarshipHoldersDto;
import com.example.prol_educa.repository.ScholarshipHoldersRepository;

@Service
public class ScholarshipHoldersService {

	@Autowired
	public ScholarshipHoldersRepository repository;
	
	@Autowired
	public CustomersService customersService;
	
	public void create(ScholarshipHoldersDto dto) throws Exception {
		ScholarshipHolders scholarshipHolders = new ScholarshipHolders();
		Customers customer = customersService.findById(dto.getCustomers());
		scholarshipHolders.setCustomers(customer);
		scholarshipHolders.setFull_name(dto.getFull_name());
		scholarshipHolders.setDate_of_birth(dto.getDate_of_birth());
		scholarshipHolders.setNeeds(dto.isNeeds());
		scholarshipHolders.setCpf(dto.getCpf());
		scholarshipHolders.setRace_color(dto.getRace_color());
		
		repository.save(scholarshipHolders);
	}
	
	public List<ScholarshipHolders> findAll(){
		return repository.findAll();
	}
	
	public ScholarshipHolders findById(Integer id) throws Exception {
		Optional<ScholarshipHolders> scholarshipHolder = repository.findById(id);
		if(!scholarshipHolder.isPresent()) {
			throw new Exception("Bolsista não encontrado");
		}
		
		return scholarshipHolder.get();
	}
	
	public ScholarshipHolders update(Integer id, ScholarshipHoldersDto dto) throws Exception {
		ScholarshipHolders scholarshipHolders = findById(id);
		Customers customer = customersService.findById(dto.getCustomers());
		scholarshipHolders.setCustomers(customer);
		scholarshipHolders.setFull_name(dto.getFull_name());
		scholarshipHolders.setDate_of_birth(dto.getDate_of_birth());
		scholarshipHolders.setNeeds(dto.isNeeds());
		scholarshipHolders.setCpf(dto.getCpf());
		scholarshipHolders.setRace_color(dto.getRace_color());
		
		return repository.save(scholarshipHolders);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}

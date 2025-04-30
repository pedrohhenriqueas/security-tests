package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Customers;
import com.example.prol_educa.models.CustomersDto;
import com.example.prol_educa.repository.CustomersRepository;

@Service
public class CustomersService {

	@Autowired
	public CustomersRepository repository;
	
	public void create(CustomersDto dto) {
		Customers customer = new Customers();
		customer.setFullName(dto.getFullName());
		customer.setEmail(dto.getEmail());
		customer.setPhone(dto.getPhone());
		customer.setCpf(dto.getCpf());
		customer.setDate_of_birth(dto.getDateOfBirth());
		customer.setStatus(dto.isStatus());
		
		repository.save(customer);
	}
	
	public Customers findById(Integer id) throws Exception {
		Optional<Customers> customer = repository.findById(id);
		if(!customer.isPresent()) {
			throw new Exception("Cliente não encontrado");
		}
		
		return customer.get();
	}
	
	public List<Customers> findAll(){
		return repository.findAll();
	}
	
	public Customers update(Integer id, CustomersDto dto) throws Exception {
		Customers customer = findById(id);
		customer.setFullName(dto.getFullName());
		customer.setEmail(dto.getEmail());
		customer.setPhone(dto.getPhone());
		customer.setCpf(dto.getCpf());
		customer.setDate_of_birth(dto.getDateOfBirth());
		customer.setStatus(dto.isStatus());
		
		return repository.save(customer);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}

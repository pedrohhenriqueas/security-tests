package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Customers;
import com.example.prol_educa.exception.ConflictException;
import com.example.prol_educa.models.CustomersDto;
import com.example.prol_educa.repository.CustomersRepository;

@Service
public class CustomersService {

	@Autowired
	public CustomersRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public void create(CustomersDto dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new ConflictException("Error: Email is already in use!");
        }

		Customers customer = new Customers();
		customer.setFullName(dto.getFullName());
		customer.setEmail(dto.getEmail());
		customer.setPhone(dto.getPhone());
		customer.setCpf(dto.getCpf());
		customer.setDate_of_birth(dto.getDateOfBirth());
		customer.setStatus(dto.isStatus());
		customer.setPassword(passwordEncoder.encode(dto.getPassword()));
		// customer.setRoles();
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
		customer.setStatus(true);
		
		return repository.save(customer);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Customers findByEmail(String email) throws Exception{
		Optional<Customers> customer = repository.findByEmail(email);
		if(!customer.isPresent()) {
			throw new Exception("Cliente não encontrado");
		}

		return customer.get();
	}
}

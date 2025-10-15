package com.example.security_tests.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security_tests.entities.Customers;
import com.example.security_tests.entities.Roles;
import com.example.security_tests.models.CustomersDto;
import com.example.security_tests.repository.CustomersRepository;
import com.example.security_tests.repository.RolesRepository;
import com.example.security_tests.utils.enuns.ERoles;

@Service
public class CustomersService {

	private final CustomersRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final RolesRepository rolesRepository;
	
	
	@Autowired
	public CustomersService(CustomersRepository repository, 
							PasswordEncoder passwordEncoder,
							RolesRepository rolesRepository) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.rolesRepository = rolesRepository;
	}

	public void create(CustomersDto dto) {
		Customers customer = new Customers();
		customer.setName(dto.getName());
		customer.setPassword(passwordEncoder.encode(dto.getPassword()));
		customer.setEmail(dto.getEmail());
		Roles userRoles = rolesRepository.findByType(ERoles.ROLE_USER);
		if (userRoles == null) 
			throw new NoSuchElementException("Error: Role USER not found.");

		customer.getRoles().add(userRoles);
		repository.save(customer);
	}
	
	public List<Customers> findAll(){
		return repository.findAll();
	}

	public Customers findByEmail(String email){
		return repository.findByEmail(email);
	}
}

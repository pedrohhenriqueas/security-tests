package com.example.security_tests.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
		customer.setEmail(dto.getEmail());
		customer.setPassword(passwordEncoder.encode(dto.getPassword()));
		Roles userRoles = rolesRepository.findByType(ERoles.ROLE_USER);
		if (userRoles == null) 
			throw new NoSuchElementException("Error: Role USER not found.");

		customer.getRoles().add(userRoles);
		repository.save(customer);
	}
	
	public Customers findById(Integer id) {
		Optional<Customers> customer = repository.findById(id);
		if(!customer.isPresent()) {
			throw new NoSuchElementException("Cliente não encontrado");
		}
		
		return customer.get();
	}
	
	public List<Customers> findAll(){
		return repository.findAll();
	}
	
	public Customers update(Integer id, CustomersDto dto) {
		Customers customer = findById(id);
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		
		return repository.save(customer);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Customers findByEmail(String email){
		return repository.findByEmail(email);
	}
}

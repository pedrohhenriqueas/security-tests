package com.example.security_tests.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security_tests.entities.Administrators;
import com.example.security_tests.entities.Roles;
import com.example.security_tests.models.AdministratorsDto;
import com.example.security_tests.repository.AdministratorsRepository;
import com.example.security_tests.repository.RolesRepository;
import com.example.security_tests.utils.enuns.ERoles;

@Service
public class AdministratorsService {
	
	private final AdministratorsRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final RolesRepository rolesRepository;

	@Autowired
	public AdministratorsService(AdministratorsRepository repository, 
									PasswordEncoder passwordEncoder,
									RolesRepository rolesRepository) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.rolesRepository = rolesRepository;
	}

	public void create(AdministratorsDto dto) {
		Administrators administrator = new Administrators();
		administrator.setName(dto.getName());
		administrator.setEmail(dto.getEmail());
		administrator.setPassword(passwordEncoder.encode(dto.getPassword()));

		Roles adminRole = rolesRepository.findByType(ERoles.ROLE_ADMIN);
		if(adminRole == null)
        	throw new IllegalArgumentException("Error: Role ADMIN not found.");
		
		administrator.getRoles().add(adminRole);
		
		repository.save(administrator);
	}
	
	public List<Administrators> findAll(){
		return repository.findAll();
	}
	
	public Administrators findById(Integer id) {
		Optional<Administrators> administrator = repository.findById(id);
		if(!administrator.isPresent())
			throw new IllegalArgumentException("Administrador nao encontrado");
		
		
		return administrator.get();
	}
	
	public Administrators update(Integer id, AdministratorsDto dto) {
		Administrators administrator = findById(id);
		administrator.setName(dto.getName());
		administrator.setEmail(dto.getEmail());
		administrator.setPassword(dto.getPassword());
		
		return repository.save(administrator);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}

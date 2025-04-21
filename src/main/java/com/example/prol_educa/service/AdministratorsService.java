package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Administrators;
import com.example.prol_educa.models.AdministratorsDto;
import com.example.prol_educa.repository.AdministratorsRepository;

@Service
public class AdministratorsService {
	
	@Autowired
	public AdministratorsRepository repository;

	public void create(AdministratorsDto dto) {
		Administrators administrator = new Administrators();
		administrator.setName(dto.getName());
		administrator.setEmail(dto.getEmail());
		administrator.setPassword(dto.getPassword());
		
		repository.save(administrator);
	}
	
	public List<Administrators> findAll(){
		return repository.findAll();
	}
	
	public Administrators findById(Integer id) throws Exception {
		Optional<Administrators> administrator = repository.findById(id);
		if(!administrator.isPresent()) {
			throw new Exception("Administrador nao encontrado");
		}
		
		return administrator.get();
	}
	
	public Administrators update(Integer id, AdministratorsDto dto) throws Exception {
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

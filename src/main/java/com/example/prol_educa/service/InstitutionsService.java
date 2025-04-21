package com.example.prol_educa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Institutions;
import com.example.prol_educa.models.InstitutionsDto;
import com.example.prol_educa.repository.InstitutionsRepository;


@Service
public class InstitutionsService {
	
	@Autowired
	public InstitutionsRepository repository;

	public void create(InstitutionsDto dto) {
		Institutions institution = new Institutions();
		institution.setName(dto.getName());
		institution.setStreet(dto.getStreet());
		institution.setNumber(dto.getNumber());
		institution.setComplement(dto.getComplement());
		institution.setNeighborhood(dto.getNeighborhood());
		institution.setCity(dto.getCity());
		institution.setState(dto.getState());
		institution.setCep(dto.getCep());
		institution.setName_responsible(dto.getName_responsible());
		institution.setCell_responsible(dto.getCell_responsible());
		institution.setEmail_responsible(dto.getEmail_responsible());
		institution.setType(dto.getType());
		institution.setUrl_image(dto.getUrl_image());
		institution.setStatus(dto.isStatus()); 
		
		repository.save(institution);
	}
	
	public List<Institutions> findAll() {
		return repository.findAll();
	}
	
	public Institutions findById(Integer id) throws Exception {
		Optional<Institutions> institution = repository.findById(id);
		if(!institution.isPresent()) {
			throw new Exception("Instituicao nao encontrada");
		}
		
		return institution.get();
	}
	
	public Institutions update(Integer id, InstitutionsDto dto) throws Exception{
		Institutions institution = findById(id);
		institution.setName(dto.getName());
		institution.setStreet(dto.getStreet());
		institution.setNumber(dto.getNumber());
		institution.setComplement(dto.getComplement());
		institution.setNeighborhood(dto.getNeighborhood());
		institution.setCity(dto.getCity());
		institution.setState(dto.getState());
		institution.setCep(dto.getCep());
		institution.setName_responsible(dto.getName_responsible());
		institution.setCell_responsible(dto.getCell_responsible());
		institution.setEmail_responsible(dto.getEmail_responsible());
		institution.setType(dto.getType());
		institution.setUrl_image(dto.getUrl_image());
		institution.setStatus(dto.isStatus()); 
		
		return repository.save(institution);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}

package com.example.prol_educa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prol_educa.entities.ScholarshipHolders;
import com.example.prol_educa.models.ScholarshipHoldersDto;
import com.example.prol_educa.service.ScholarshipHoldersService;

@RestController
@RequestMapping("/scholarship-holders")
public class ScholarshipHoldersController {

	@Autowired
	public ScholarshipHoldersService service;
	
	//cliente
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> create(@RequestBody ScholarshipHoldersDto dto) throws Exception{
		service.create(dto);
		return ResponseEntity.ok("Cadastro do bolsista feito com sucesso");
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<ScholarshipHolders>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ScholarshipHolders> findById(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
									 @RequestBody ScholarshipHoldersDto dto) throws Exception{
		service.update(id, dto);
		return ResponseEntity.ok("Bolsista atualizado com sucesso");
	}
	
	//cliente
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN', 'USER')")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Bolsista deletado com sucesso");
	}
}

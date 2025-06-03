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

import com.example.prol_educa.entities.Registrations;
import com.example.prol_educa.models.RegistrationsDto;
import com.example.prol_educa.service.RegistrationsService;

@RestController
@RequestMapping("/registrations")
public class RegistratiosController {
	
	@Autowired
	public RegistrationsService service;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RegistrationsDto dto) throws Exception{
		service.create(dto);
		return ResponseEntity.ok("Registro criado com sucesso");
	}
	
	@GetMapping
	public ResponseEntity<List<Registrations>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Registrations> findById(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
									@RequestBody RegistrationsDto dto) throws Exception{
		service.update(id, dto);
		return ResponseEntity.ok("Registro atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Registro deletado com sucesso");
	}
	
 }

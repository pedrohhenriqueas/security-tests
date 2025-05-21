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

import com.example.prol_educa.entities.Institutions;
import com.example.prol_educa.models.InstitutionsDto;
import com.example.prol_educa.service.InstitutionsService;

@RestController
@RequestMapping("/institutions")
public class InstitutionsController {
	
	@Autowired
	public InstitutionsService service;

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> create(@RequestBody InstitutionsDto dto) {
		service.create(dto);
		return ResponseEntity.ok("Cadastro da instituicao realizado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<List<Institutions>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Institutions> findById(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
								@RequestBody InstitutionsDto dto) throws Exception {
		service.update(id, dto);
		return ResponseEntity.ok("Instituição atualizada com sucesso");
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Instituição deletada com sucesso");
	}
}

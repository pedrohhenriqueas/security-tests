package com.example.prol_educa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prol_educa.entities.Administrators;
import com.example.prol_educa.models.AdministratorsDto;
import com.example.prol_educa.service.AdministratorsService;

@RestController
@RequestMapping("/administrators")
public class AdministratorsController {

	@Autowired
	public AdministratorsService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody AdministratorsDto dto) {
		service.create(dto);
		return ResponseEntity.ok("Cadastro do administrador realizado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<List<Administrators>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Administrators> findById(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, 
									@RequestBody AdministratorsDto dto) throws Exception{
		service.update(id, dto);
		return ResponseEntity.ok("Administrador atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Administrador deletado com sucesso");
	}
	
}

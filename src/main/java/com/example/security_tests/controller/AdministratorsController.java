package com.example.security_tests.controller;

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

import com.example.security_tests.entities.Administrators;
import com.example.security_tests.models.AdministratorsDto;
import com.example.security_tests.service.AdministratorsService;

@RestController
@RequestMapping("/administrators")
public class AdministratorsController {

	private final AdministratorsService administratorsService;
	
	@Autowired
	public AdministratorsController(AdministratorsService administratorsService) {
		this.administratorsService = administratorsService;
	}

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody AdministratorsDto dto) {
		administratorsService.create(dto);
		return ResponseEntity.ok("Cadastro do administrador realizado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<List<Administrators>> findAll(){
		return ResponseEntity.ok(administratorsService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Administrators> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(administratorsService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id, 
									@RequestBody AdministratorsDto dto) throws Exception{
		administratorsService.update(id, dto);
		return ResponseEntity.ok("Administrador atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		administratorsService.delete(id);
		return ResponseEntity.ok("Administrador deletado com sucesso");
	}
	
}

package com.example.security_tests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/register")
	public ResponseEntity<Object> create(@RequestBody AdministratorsDto dto) {
		administratorsService.create(dto);
		return ResponseEntity.ok("Cadastro do administrador realizado com sucesso!");
	}
	
	@GetMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> restrictedMethod() {
		return ResponseEntity.ok("Apenas administradortes podem acessar essa rota");
	}
}

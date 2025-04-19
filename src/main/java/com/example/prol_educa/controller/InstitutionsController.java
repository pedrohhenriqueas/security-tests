package com.example.prol_educa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prol_educa.models.InstitutionsDto;
import com.example.prol_educa.service.InstitutionsService;

@RestController
@RequestMapping("/institutions")
public class InstitutionsController {
	
	@Autowired
	public InstitutionsService service;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody InstitutionsDto dto) {
		service.create(dto);
		return ResponseEntity.ok("Cadastro da instituição realizado com sucesso!");
	}
}

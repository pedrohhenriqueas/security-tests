package com.example.prol_educa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prol_educa.models.CustomersDto;
import com.example.prol_educa.service.CustomersService;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	public CustomersService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CustomersDto dto){
		service.create(dto);
		return ResponseEntity.ok("Cliente cadastrado com sucesso");
	}
}

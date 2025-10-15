package com.example.security_tests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security_tests.models.CustomersDto;
import com.example.security_tests.service.CustomersService;

@RestController
@RequestMapping("/users")
public class CustomersController {

	private final CustomersService customersService;

	@Autowired
	public CustomersController(CustomersService customersService) {
		this.customersService = customersService;
	}

	@PostMapping("/register")
	public ResponseEntity<Object> create(@RequestBody CustomersDto dto){

		if (customersService.findByEmail(dto.getEmail()) != null) 
			return ResponseEntity.badRequest().body("Email já está em uso");

		customersService.create(dto);
		return ResponseEntity.ok("Cliente cadastrado com sucesso");
	}

}

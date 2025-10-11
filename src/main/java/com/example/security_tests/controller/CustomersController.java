package com.example.security_tests.controller;

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

import com.example.security_tests.entities.Customers;
import com.example.security_tests.models.CustomersDto;
import com.example.security_tests.service.CustomersService;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	private final CustomersService customersService;

	@Autowired
	public CustomersController(CustomersService customersService) {
		this.customersService = customersService;
	}

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody CustomersDto dto){

		if (customersService.findByEmail(dto.getEmail()) != null) 
			return ResponseEntity.badRequest().body("Email já está em uso");

		customersService.create(dto);
		return ResponseEntity.ok("Cliente cadastrado com sucesso");
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> findAll(){
		List<Customers> customers = customersService.findAll();
		
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(customersService.findById(id));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id,
									@RequestBody CustomersDto dto) {
		customersService.update(id, dto);
		return ResponseEntity.ok("Cliente atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		customersService.delete(id);
		return ResponseEntity.ok("Cliente deletado com sucesso");
	}
	
}

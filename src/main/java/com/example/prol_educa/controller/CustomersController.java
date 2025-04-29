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

import com.example.prol_educa.entities.Customers;
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
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Customers> customers = service.findAll();
		
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
									@RequestBody CustomersDto dto) throws Exception{
		service.update(id, dto);
		return ResponseEntity.ok("Cliente atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Cliente deletado com sucesso");
	}
	
}

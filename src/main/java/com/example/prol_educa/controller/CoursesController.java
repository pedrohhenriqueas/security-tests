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

import com.example.prol_educa.entities.Courses;
import com.example.prol_educa.models.CoursesDto;
import com.example.prol_educa.service.CoursesService;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	public CoursesService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CoursesDto dto) throws Exception{
		service.create(dto);
		return ResponseEntity.ok("Cadastro do curso feito com sucesso");
	}
	
	@GetMapping
	public ResponseEntity<List<Courses>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Courses> findById(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
									 @RequestBody CoursesDto dto) throws Exception{
		service.update(id, dto);
		return ResponseEntity.ok("Curso atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Curso deletado com sucesso");
	}
}

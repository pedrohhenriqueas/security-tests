package com.example.prol_educa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
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
	@PreAuthorize("hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable("id") Integer id,
									 @RequestBody CoursesDto dto) throws Exception{
		service.update(id, dto);
		return ResponseEntity.ok("Curso atualizado com sucesso");
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.delete(id);
		return ResponseEntity.ok("Curso deletado com sucesso");
	}
	
	//cliente
	// @GetMapping("/findByName")
	// @PreAuthorize("hasRole('ADMIN', 'USER')")
	// public ResponseEntity<?> findByName(@RequestParam("name") String name){
	// 	return ResponseEntity.ok(service.findByName(name));
	// }
	
	// @GetMapping("/findByInstitution")
	// public ResponseEntity<?> findByInstitution(@RequestParam("institutionName") String institutionName){
	// 	return ResponseEntity.ok(service.findByInstituitions_Name(institutionName));
	// }
	
	// @GetMapping("/findByPercentageScholarship")
	// public ResponseEntity<?> findByPercentageScholarship(@RequestParam("percentageScholarship") BigDecimal percentageScholarship){
	// 	return ResponseEntity.ok(service.findByPercentageScholarship(percentageScholarship));
	// }
	
	//cliente
	//adicioonar cidade e categoria
	@GetMapping("/filter")
	public ResponseEntity<?> findByFilter(
			@RequestParam(required = false) String name,
	        @RequestParam(required = false) String institutions,
	        @RequestParam(required = false) String shift,
	        @RequestParam(required = false) String minPercentageScholarship,
			@RequestParam(required = false) String city,
	        @RequestParam(required = false) String category){
		Map<String, String> filters = new HashMap<>();

        if (name != null) filters.put("name", name);
        if (institutions != null) filters.put("institutions", institutions);
        if (shift != null) filters.put("shift", shift);
        if (minPercentageScholarship != null) filters.put("minPercentageScholarship", minPercentageScholarship);
        if (city != null) filters.put("city", city);
        if (category != null) filters.put("category", category);

        List<Courses> result = service.filter(filters);
        return ResponseEntity.ok(result);
	}
	
}

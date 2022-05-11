package com.company.dashboard.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.dashboard.model.Project;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Generic Type Resource Interface
 */
public interface Resource {
	
	@GetMapping("/find-all")
	Page<Project> findAll(Pageable pageable);
	
	@GetMapping("{id}")
	ResponseEntity<Project> findById(@PathVariable Integer id);
	
	@PostMapping("/save")
	ResponseEntity<Project> save(@RequestBody Project project);
	
	@PutMapping("/update/{id}")
	ResponseEntity<Project> update(@PathVariable Integer id,@RequestBody Project project);
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id);

}

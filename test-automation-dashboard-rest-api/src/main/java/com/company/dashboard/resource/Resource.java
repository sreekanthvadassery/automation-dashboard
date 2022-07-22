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

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Generic Type Resource Interface
 */
public interface Resource<T> {
	
	@GetMapping("/find-all")
	Page<T> findAll(Pageable pageable);
	
	@GetMapping("{id}")
	ResponseEntity<T> findById(@PathVariable Integer id);
	
	@PostMapping("/save")
	ResponseEntity<T> save(@RequestBody T t);
	
	@PutMapping("/update/{id}")
	ResponseEntity<T> update(@PathVariable Integer id,@RequestBody T t);
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id);

}

package com.company.dashboard.resource.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dashboard.model.Project;
import com.company.dashboard.resource.Resource;
import com.company.dashboard.service.ProjectService;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * class for Project Resource - Implements Generic Resource
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/project")
public class ProjectResourceImpl implements Resource{
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/find-all")
	public Page<Project> findAll(Pageable pageable){
		return projectService.findAll(pageable);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Project> findById(@PathVariable Integer id){
		return projectService.findById(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Project> save(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Project> update(@PathVariable Integer id,@RequestBody Project project){
		return projectService.update(id, project);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
		return projectService.deleteById(id);
	}

}

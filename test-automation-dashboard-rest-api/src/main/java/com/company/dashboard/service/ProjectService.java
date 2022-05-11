package com.company.dashboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.company.dashboard.model.Project;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Service Interface for Project
 */
public interface ProjectService {
	
	public Page<Project> findAll(Pageable pageable);
	
	public ResponseEntity<Project> findById(Integer projectId);
	
	public ResponseEntity<Project> save(Project project);
	
	public ResponseEntity<Project> update(Integer projectId, Project project);
	
	public ResponseEntity<HttpStatus> deleteById(Integer projectId);

}

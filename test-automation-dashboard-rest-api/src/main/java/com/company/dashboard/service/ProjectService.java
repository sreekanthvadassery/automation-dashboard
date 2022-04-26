package com.company.dashboard.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.company.dashboard.model.Project;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Service Interface for Project
 */
public interface ProjectService {
	
	public List<Project> findAll();
	
	public ResponseEntity<Project> findById(Integer projectId);
	
	public ResponseEntity<Project> save(Project project);
	
	public ResponseEntity<Project> update(Integer projectId, Project project);
	
	public ResponseEntity<HttpStatus> deleteById(Integer projectId);

}

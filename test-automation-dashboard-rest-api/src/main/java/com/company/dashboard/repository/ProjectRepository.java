package com.company.dashboard.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.company.dashboard.model.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Repository interface for Project entity
 */
public interface ProjectRepository extends JpaRepositoryImplementation<Project, Integer>{
	
	//Page<Project> findByEnabled(Boolean enabled,Pageable pageable);
	
	//Page<Project> findByProjectNameContaining(String projectName,Pageable pageable);
}

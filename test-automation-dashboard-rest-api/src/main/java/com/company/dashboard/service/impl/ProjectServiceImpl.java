package com.company.dashboard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.dashboard.exception.ResourceNotFoundException;
import com.company.dashboard.model.Project;
import com.company.dashboard.repository.ProjectRepository;
import com.company.dashboard.service.ProjectService;
import com.company.dashboard.utils.DateUtils;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Project Service Implementation
 */
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public ResponseEntity<Project> findById(Integer projectId) {
		Project project = projectRepository.findById(projectId)
				.orElseThrow( () -> new ResourceNotFoundException("Project not exist with id: "+projectId) );
		return ResponseEntity.ok(project);
	}

	@Override
	public ResponseEntity<Project> save(Project project) {
		project = projectRepository.save(project);
		return ResponseEntity.ok(project);
	}

	@Override
	public ResponseEntity<Project> update(Integer projectId, Project project) {
		
		/*Project updateProject = projectRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Project not exist with id: "+id) );*/
		
		Optional<Project> projectFromDb = projectRepository.findById(projectId);
		if(projectFromDb==null) {
			throw new ResourceNotFoundException("Project not exist with id: "+projectId) ;
		}
		projectFromDb.get()
						.setProjectName(project.getProjectName())
						.setProjectDescription(project.getProjectDescription())
						.setEnabled(project.getEnabled())
						.setCreatedAt(project.getCreatedAt())
						.setUpdatedAt(DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss"))
						.setLastUpdatedBy("Logged in User");
		//saving
		projectRepository.save(projectFromDb.get());
		
		return ResponseEntity.ok(projectFromDb.get());
	}

	@Override
	public ResponseEntity<HttpStatus> deleteById(Integer projectId) {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id: "+projectId) );
		projectRepository.delete(project);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}

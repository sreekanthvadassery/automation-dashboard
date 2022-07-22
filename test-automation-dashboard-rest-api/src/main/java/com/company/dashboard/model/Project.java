package com.company.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Model class for Project entity
 */
@Entity
@Table(name="project", catalog = "automation_dashboard")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	
	@Column(name="projectName")
	private String projectName;
	
	@Column(name="projectDescription")
	private String projectDescription;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name="createdAt")
	private String createdAt;
	
	@Column(name="updatedAt")
	private String updatedAt;
	
	@Column(name="lastUpdatedBy")
	private String lastUpdatedBy;
	
	public Integer getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public Project setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
	
	public String getProjectDescription() {
		return projectDescription;
	}
	
	public Project setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
		return this;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public Project setEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public Project setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public Project setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	
	public Project setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
		return this;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", enabled=" + enabled + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

}

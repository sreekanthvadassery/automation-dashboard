package com.company.dashboard.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220722
 * Model class for Role entity
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "role", catalog = "automation_dashboard")
public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId")
	private Integer roleId;

	@Column(name = "role")
	private String role;

	@Column(name = "roleDescription")
	private String roleDescription;

	@Override
	public String getAuthority() {
		return role;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + ", roleDescription=" + roleDescription + "]";
	}

}

package com.company.dashboard;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.company.dashboard.model.Role;
import com.company.dashboard.model.User;
import com.company.dashboard.repository.UserRepository;

@SpringBootApplication
public class TestAutomationDashboardRestApiApplication {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestAutomationDashboardRestApiApplication.class, args);
	}
	
	/*
	//Used for initializing the data for the first time
	@PostConstruct
	protected void init() {
		List<Role> roleList = new ArrayList<Role>();
		roleList.add(createRole("ADMIN", "Admin Role"));
		roleList.add(createRole("MODERATOR", "Moderator Role"));
		roleList.add(createRole("USER", "User Role"));
		
		User user = new User();
		user.setUsername("202221");
		user.setFirstName("Sreekanth");
		user.setLastName("Vadassery");
		user.setEmail("sreekanth.vadassery@ibsplc.com");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setVerifyPassword(passwordEncoder.encode("admin"));
		user.setEnabled(true);
		user.setRoles(roleList);
		 
		userRepository.save(user);
	}
	
	private Role createRole(String role, String roleDescription) {
		Role roleObj = new Role();
		roleObj.setRole(role);
		roleObj.setRoleDescription(roleDescription);
		return roleObj;
	}
	*/
	
}

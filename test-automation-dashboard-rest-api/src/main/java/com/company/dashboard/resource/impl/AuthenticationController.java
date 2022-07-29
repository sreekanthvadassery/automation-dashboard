package com.company.dashboard.resource.impl;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dashboard.config.JWTTokenHelper;
import com.company.dashboard.model.User;
import com.company.dashboard.request.AuthenticationRequest;
import com.company.dashboard.response.LoginResponse;
import com.company.dashboard.response.UserInfo;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220722
 * Controller for Authentication
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
//@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authentincationManager;
	
	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException{
		
		final Authentication authentication = authentincationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())	);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user = (User)authentication.getPrincipal();
		
		String jwtToken = jwtTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response = new LoginResponse();
		
		response.setToken(jwtToken);
		 
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/userinfo")
	public ResponseEntity<?> getUserInfo(Principal user){
		User userObj = (User) userDetailsService.loadUserByUsername(user.getName());
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(userObj.getUsername());
		userInfo.setFirstName(userObj.getFirstName());
		userInfo.setLastName(userObj.getLastName());
		userInfo.setEmail(userObj.getEmail());
		userInfo.setRoles(userObj.getAuthorities().toArray());
		
		return ResponseEntity.ok(userInfo);
		
	}
	
}

package com.company.dashboard.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220722
 */
public class JWTAuthenticationFilter extends OncePerRequestFilter{
	
	private UserDetailsService userDetailService;
	private JWTTokenHelper jwtTokenHelper;
	
	public JWTAuthenticationFilter(UserDetailsService userDetailService,JWTTokenHelper jwtTokenHelper) {
		this.userDetailService = userDetailService;
		this.jwtTokenHelper = jwtTokenHelper;
	}

	//This method will be called during every request
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		//find auth token from request
		String authToken = jwtTokenHelper.getToken(request);
		//If authToken is not null
		if(authToken!=null) {
			//find userName from authToken
			String userName = jwtTokenHelper.getUsernameFromToken(authToken);
			if(userName!=null) {
				//find userDetails from userName
				UserDetails userDetails = userDetailService.loadUserByUsername(userName);
				//validate token
				if(jwtTokenHelper.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}

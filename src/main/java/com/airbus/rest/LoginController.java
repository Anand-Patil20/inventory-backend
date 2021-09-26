package com.airbus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.domain.Product;
import com.airbus.domain.User;
import com.airbus.service.LoginService;
import com.airbus.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		User userResult=loginService.saveUser(user);
		return userResult;
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody User auth) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
		}
		catch(Exception e) {
			throw new Exception("Invalid user");
		}
		return jwtUtil.generateToken(auth.getUsername());
	}
}

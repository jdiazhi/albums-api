package com.wolox.albums.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.albums.model.User;
import com.wolox.albums.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/")
	public ResponseEntity<User[]> getUsers(HttpServletResponse response) {		
		return new ResponseEntity<User[]>(userService.getUsers(), HttpStatus.OK);		
	}
		

}

package com.wolox.albums.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.albums.model.User;
import com.wolox.albums.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	private static final String URL = "http://jsonplaceholder.typicode.com/users";
	
	@Autowired
	private RestTemplate restTemplate;

	public User[] getUsers() {
		return restTemplate.getForObject(URL, User[].class);
	}

}

package com.wolox.albums.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.albums.model.Comment;
import com.wolox.albums.resource.FilterData;
import com.wolox.albums.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService{
	
	private static final String URL = "http://jsonplaceholder.typicode.com/comments";
	
	@Autowired
	private RestTemplate restTemplate;

	public Comment[] findByNameOrUser(FilterData filter) {
		if(filter.getUser().equals("")) {
			return restTemplate.getForObject(URL+"?name="+filter.getName(), Comment[].class);
		}else if(filter.getName().equals("")) {
			return restTemplate.getForObject(URL+"?email="+filter.getUser(), Comment[].class);
		}else {
			return restTemplate.getForObject(URL+"?email="+filter.getUser()+"&name="+filter.getName(), Comment[].class);
		}
	}

}

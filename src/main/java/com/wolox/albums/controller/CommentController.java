package com.wolox.albums.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.albums.model.Comment;
import com.wolox.albums.resource.FilterData;
import com.wolox.albums.service.ICommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	/**
	 * 
	 * @param response
	 * @param name
	 * @param user (email of user)
	 * @return List of Comments by name or user
	 */
	@PostMapping("/findByNameOrUser")
	public ResponseEntity<Comment[]> getPhotos(HttpServletResponse response, @RequestBody FilterData filter) {		
		return new ResponseEntity<Comment[]>(commentService.findByNameOrUser(filter), HttpStatus.OK);		
	}

}

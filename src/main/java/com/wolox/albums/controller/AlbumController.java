package com.wolox.albums.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.albums.model.Album;
import com.wolox.albums.service.IAlbumService;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@GetMapping("/")
	public ResponseEntity<Album[]> getAlbums(HttpServletResponse response) {		
		return new ResponseEntity<Album[]>(albumService.getAlbums(), HttpStatus.OK);		
	}
	
	/**
	 * 
	 * @param response
	 * @param userId
	 * @return List of albums by user filter
	 */
	@GetMapping("/user/{userId}")
	public ResponseEntity<Album[]> getAlbumsByUser(HttpServletResponse response, @PathVariable int userId) {		
		return new ResponseEntity<Album[]>(albumService.findByUser(userId), HttpStatus.OK);		
	}

}

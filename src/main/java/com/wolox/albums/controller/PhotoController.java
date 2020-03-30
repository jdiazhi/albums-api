package com.wolox.albums.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.albums.model.Photo;
import com.wolox.albums.service.IPhotoService;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	@GetMapping("/")
	public ResponseEntity<Photo[]> getPhotos(HttpServletResponse response) {		
		return new ResponseEntity<Photo[]>(photoService.getPhotos(), HttpStatus.OK);		
	}
	
	/**
	 * 
	 * @param response
	 * @param userId
	 * @return List of photos by user
	 */
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Photo>> getPhotos(HttpServletResponse response, @PathVariable int userId) {		
		return new ResponseEntity<List<Photo>>(photoService.findByUser(userId), HttpStatus.OK);		
	}

}

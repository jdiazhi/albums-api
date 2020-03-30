package com.wolox.albums.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.albums.model.AlbumPermit;
import com.wolox.albums.model.User;
import com.wolox.albums.service.IAlbumPermitService;

@RestController
@RequestMapping("/api/albumPermits")
public class AlbumPermitController {
	
	@Autowired
	private IAlbumPermitService albumPermitService;
	
	@PostMapping
	public ResponseEntity<Void> addAlbumPermit(@RequestBody AlbumPermit albumPermit) {
		albumPermitService.addUserPermit(albumPermit);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param albumPermit
	 * @param userId
	 * @param albumId
	 * @return
	 */
	@PutMapping("/user/{userId}/album/{albumId}")
	public ResponseEntity<Void> updateAlbumPermit(@RequestBody AlbumPermit albumPermit, @PathVariable int userId, @PathVariable int albumId) {
		albumPermitService.updateUserPermit(albumPermit, userId, albumId);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param response
	 * @param albumId
	 * @param permit (read = 0, write=1)
	 * @return List of user by album and permit
	 */
	@GetMapping("/album/{albumId}/permit/{permit}")
	public ResponseEntity<List<User>> getPhotos(HttpServletResponse response, @PathVariable int albumId, @PathVariable int permit) {		
		return new ResponseEntity<List<User>>(albumPermitService.findUserByPermitAndAlbum(permit, albumId), HttpStatus.OK);		
	}

}

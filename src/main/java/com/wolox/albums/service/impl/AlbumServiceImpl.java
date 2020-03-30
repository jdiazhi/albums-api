package com.wolox.albums.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.albums.model.Album;
import com.wolox.albums.service.IAlbumService;

@Service
public class AlbumServiceImpl implements IAlbumService{
	
private static final String URL = "http://jsonplaceholder.typicode.com/albums";
	
	@Autowired
	private RestTemplate restTemplate;

	public Album[] getAlbums() {		
		return restTemplate.getForObject(URL, Album[].class);
	}

	public Album[] findByUser(int userId) {
		return restTemplate.getForObject(URL+"?userId="+userId, Album[].class);
	}

}

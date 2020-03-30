package com.wolox.albums.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.albums.model.Album;
import com.wolox.albums.model.Photo;
import com.wolox.albums.service.IPhotoService;

@Service
public class PhotoServiceImpl implements IPhotoService{

private static final String URL = "http://jsonplaceholder.typicode.com/photos";
	
	@Autowired
	private RestTemplate restTemplate;

	public Photo[] getPhotos() {
		return restTemplate.getForObject(URL, Photo[].class);
	}

	public List<Photo> findByUser(int userId) {
		List<Photo> photos = new ArrayList<Photo>();
		Album[] albums = restTemplate.getForObject("http://jsonplaceholder.typicode.com/users/"+userId+"/albums", Album[].class);
		for(Album album: albums) {
			Photo[] photosAlbum = restTemplate.getForObject("http://jsonplaceholder.typicode.com/albums/"+album.getId()+"/photos", Photo[].class);
			photos.addAll(Arrays.asList(photosAlbum));
		}
		return photos;
	}

}

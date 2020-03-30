package com.wolox.albums.service;

import java.util.List;

import com.wolox.albums.model.Photo;

public interface IPhotoService {
	
	Photo[] getPhotos();
	
	List<Photo> findByUser(int userId);

}

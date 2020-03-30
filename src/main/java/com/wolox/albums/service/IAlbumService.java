package com.wolox.albums.service;

import com.wolox.albums.model.Album;

public interface IAlbumService {
	
	Album[] getAlbums();
	
	Album[] findByUser(int userId);

}

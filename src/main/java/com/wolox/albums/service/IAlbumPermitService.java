package com.wolox.albums.service;

import java.util.List;

import com.wolox.albums.model.AlbumPermit;
import com.wolox.albums.model.User;

public interface IAlbumPermitService {
	
	void addUserPermit(AlbumPermit albumPermit);
	
	void updateUserPermit(AlbumPermit albumPermit, int userId, int albumId);
	
	List<User> findUserByPermitAndAlbum(int permit, int albumId);

}

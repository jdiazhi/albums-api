package com.wolox.albums.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.albums.model.AlbumPermit;
import com.wolox.albums.model.User;
import com.wolox.albums.service.IAlbumPermitService;

@Service
public class AlbumPermitServiceImpl implements IAlbumPermitService{
	
	private static final String URL = "https://my-json-server.typicode.com/jdiazhi/albums/album_permits";
	private static final String ALBUM_ID = "?albumId=";
	
	@Autowired
	private RestTemplate restTemplate;

	public void addUserPermit(AlbumPermit albumPermit) {		
		restTemplate.postForEntity(URL, albumPermit, AlbumPermit.class);		
	}

	public void updateUserPermit(AlbumPermit albumPermit, int userId, int albumId) {
		AlbumPermit[] albumPermitOld = restTemplate.getForObject(URL+ALBUM_ID+albumId+"&userId="+userId, AlbumPermit[].class);
		if(albumPermitOld.length > 0) {
			restTemplate.put(URL+"/"+albumPermitOld[0].getId(), albumPermit);
		}
	}

	public List<User> findUserByPermitAndAlbum(int permit, int albumId) {
		List<User> users = new ArrayList<User>();
		if(permit == 0) {			
			AlbumPermit[] albumPermits = restTemplate.getForObject(URL+ALBUM_ID+albumId+"&read=true", AlbumPermit[].class);
			for(AlbumPermit albumPermit: albumPermits) {
				User user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/users/"+albumPermit.getUserId(), User.class);
				users.addAll(Arrays.asList(user));
			}
			return users;
		}else {
			AlbumPermit[] albumPermits = restTemplate.getForObject(URL+ALBUM_ID+albumId+"&write=true", AlbumPermit[].class);
			for(AlbumPermit albumPermit: albumPermits) {
				User user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/users/"+albumPermit.getUserId(), User.class);
				users.addAll(Arrays.asList(user));
			}
			return users;
		}
	}

}

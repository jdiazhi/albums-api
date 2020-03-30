package com.wolox.albums.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumPermit {
	
	int id;
	int userId;
	int albumId;
	boolean read;
	boolean write;

}

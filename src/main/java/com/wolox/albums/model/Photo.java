package com.wolox.albums.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	
	int albumId;
    int id;
    String title;
    String url;
    String thumbnailUrl;

}

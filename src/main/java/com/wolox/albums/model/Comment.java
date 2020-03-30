package com.wolox.albums.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	int postId;
    int id;
    String name;
    String email;
    String body;

}

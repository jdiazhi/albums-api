package com.wolox.albums.service;

import com.wolox.albums.model.Comment;
import com.wolox.albums.resource.FilterData;

public interface ICommentService {
	
	Comment[] findByNameOrUser(FilterData filter);

}

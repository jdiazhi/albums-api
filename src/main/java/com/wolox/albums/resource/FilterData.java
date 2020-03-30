package com.wolox.albums.resource;

import java.io.Serializable;

import lombok.Data;

@Data
public class FilterData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	
	protected String user;
	
}

package com.wolox.albums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AlbumsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AlbumsApplication.class, args);
	}
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

}

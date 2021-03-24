package com.iperrota.graapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.iperrota.graapi.job.CreateMoviesDB;

import org.junit.jupiter.api.Assertions;

@SpringBootTest(classes = GoldenRaspAwardsApiApplication.class,
		webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class GoldenRaspAwardsApiApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGetPremiados() {
		
        CreateMoviesDB createMoviesDB = new CreateMoviesDB();
        try {
        	createMoviesDB.loadData("movielisttest.csv");	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
		ResponseEntity<String> response =
				restTemplate.getForEntity("http://localhost:" + port + "/premiados", String.class);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

}

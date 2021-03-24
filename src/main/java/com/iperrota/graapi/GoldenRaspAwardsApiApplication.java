package com.iperrota.graapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iperrota.graapi.job.CreateMoviesDB;

@SpringBootApplication
public class GoldenRaspAwardsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldenRaspAwardsApiApplication.class, args);
		
        CreateMoviesDB createMoviesDB = new CreateMoviesDB();
        try {
        	createMoviesDB.loadData("movielist.csv");	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
	}

}

package com.iperrota.graapi.job;

import com.iperrota.graapi.model.Movie;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import java.io.FileReader;

public class LoadMoviesList {
	
	public ArrayList<Movie> getListMovies(String fileName) throws Exception {
		
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		
		String root = System.getProperty("user.dir");
		FileReader file = new FileReader(root + "//src//main//resources//" + fileName);
		
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		
		CSVReader csvReader = new CSVReaderBuilder(file).withCSVParser(parser).build();
		
		String[] nextMovie;
		int movieNumber = 0;
		boolean winner = false;
		String[] studios;
		String[] producers;
		
		while ((nextMovie = csvReader.readNext()) != null) {
			if (movieNumber != 0 && nextMovie.length > 4) {
			    winner = nextMovie[4].equals("yes")?true:false;
			    studios = nextMovie[2].trim().split("\\s*,\\s*");
			    producers = nextMovie[3].trim().split("\\s*,\\s*");
			    
				Movie movie = new Movie(movieNumber, Integer.parseInt(nextMovie[0]), nextMovie[1], studios, producers, winner);
			    movieList.add(movie);				
			}
			movieNumber++;
		}
		
		return movieList;
	}

}

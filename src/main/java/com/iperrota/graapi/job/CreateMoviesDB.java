package com.iperrota.graapi.job;

import java.sql.*;
import com.iperrota.graapi.job.LoadMoviesList;
import com.iperrota.graapi.dao.DBConnection;

import com.iperrota.graapi.model.Movie;
import java.util.ArrayList;

public class CreateMoviesDB {

    public void loadData(String fileName) throws Exception {
    	
    	DBConnection dbConn = new DBConnection();
    	Connection conn = DBConnection.getConnection();
    	
        // Create Movies Table
        String sql = "CREATE TABLE MOVIES " + 
	        "(ID INTEGER NOT NULL, " +
	        " YEAR INTEGER, " + 
	        " TITLE VARCHAR(255), " +  
	        " WINNER BOOLEAN, " +
	        " PRIMARY KEY ( ID ))";
        
    	dbConn.execSQL(conn, sql);
        
        // Create Movies Studios Table
        sql = "CREATE TABLE MOVIES_STUDIOS " + 
	        "(ID_MOVIE INTEGER NOT NULL, " +
	        " STUDIO VARCHAR(255) NOT NULL, " + 
	        " PRIMARY KEY ( ID_MOVIE, STUDIO ))";
        
        dbConn.execSQL(conn, sql);
        
        // Create Movies Producers Table
        sql = "CREATE TABLE MOVIES_PRODUCERS " + 
	        "(ID_MOVIE INTEGER NOT NULL, " +
	        " PRODUCER VARCHAR(255) NOT NULL, " + 
	        " PRIMARY KEY ( ID_MOVIE, PRODUCER ))";
        
        dbConn.execSQL(conn, sql);
        
        // Import Movies List to MOVIES table
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        
        LoadMoviesList loadMoviesList = new LoadMoviesList();
        movieList = loadMoviesList.getListMovies(fileName);
        
        String sqlMovie = "INSERT INTO MOVIES (ID, YEAR, TITLE, WINNER) "
    			+ "VALUES (?, ?, ?, ?)";
        String sqlStudio = "INSERT INTO MOVIES_STUDIOS (ID_MOVIE, STUDIO) "
    			+ "VALUES (?, ?)";
        String sqlProducer = "INSERT INTO MOVIES_PRODUCERS (ID_MOVIE, PRODUCER) "
    			+ "VALUES (?, ?)";
        
        for (int i = 0; i < movieList.size(); i++) {
        	dbConn.insertMovie(conn, sqlMovie, movieList.get(i).getId(), movieList.get(i).getYear(), movieList.get(i).getTitle(), movieList.get(i).isWinner());
        	for (int j = 0; j < movieList.get(i).getStudios().length; j++) {
        		dbConn.insertMovieStudio(conn, sqlStudio, movieList.get(i).getId(), movieList.get(i).getStudios()[j]);
        	}
        	for (int j = 0; j < movieList.get(i).getProducers().length; j++) {
        		dbConn.insertMovieProducer(conn, sqlProducer, movieList.get(i).getId(), movieList.get(i).getProducers()[j]);
        	}
        }
        
        //conn.close();
	}
}

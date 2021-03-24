package com.iperrota.graapi.dao;

import java.sql.*;

public class DBConnection {
	
	public static java.sql.Connection getConnection() {
		
		try {
			// Open Connection to gradb
			Class.forName("org.h2.Driver"); 
		    Connection conn = DriverManager.getConnection("jdbc:h2:mem:gradb", "admin", "pwd");	
		    return conn;
		} catch (SQLException se) {
			return null;
		} catch (ClassNotFoundException ce) {
			return null;
		}
		
	}
	
	public void execSQL(Connection conn, String sql) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException se) {
			System.out.println("Statement execSQL Error: " + se );
		}

	}
	
	public void insertMovie(Connection conn, String sql, int id, int year, String title, boolean winner) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, year);
			pstmt.setString(3, title);
			pstmt.setBoolean(4, winner);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException se) {
			System.out.println("Statement insertMovie Error");
		}

	}
	
	public void insertMovieStudio(Connection conn, String sql, int idMovie, String studio) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idMovie);
			pstmt.setString(2, studio);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException se) {
			System.out.println("Statement insertMovieStudio Error");
		}

	}
	
	public void insertMovieProducer(Connection conn, String sql, int idMovie, String producer) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idMovie);
			pstmt.setString(2, producer);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException se) {
			System.out.println("Statement insertMovieProducer Error");
		}

	}
	
	public ResultSet execQuery(Connection conn, String sql) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			return rs;
			
		} catch (SQLException se) {
			System.out.println("Statement execQuery Error");
			return null;
		}

	}
	
}

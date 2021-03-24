package com.iperrota.graapi.services;

import com.iperrota.graapi.model.Premiados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.iperrota.graapi.dao.DBConnection;

public class PremiadosService {
	

	public ArrayList<Premiados> getMinPremiados() throws Exception {
		
    	DBConnection dbConn = new DBConnection();
    	Connection conn = DBConnection.getConnection();
    	
		ArrayList<Premiados> premiadosList = new ArrayList<Premiados>();
		
		String sql = "SELECT YEAR_NEXT - YEAR AS YEARS_DIFF, YEAR, YEAR_NEXT, PRODUCER FROM ("
				+ " SELECT M.YEAR, LEAD(M.YEAR)  OVER (PARTITION BY MP.PRODUCER ORDER BY M.YEAR) AS YEAR_NEXT, MP.PRODUCER"
				+ " 				FROM MOVIES AS M INNER JOIN MOVIES_PRODUCERS AS MP"
				+ " 						ON M.ID = MP.ID_MOVIE"
				+ " 				 WHERE M.WINNER = true"
				+ " 				 ORDER BY MP.PRODUCER, M.YEAR"
				+ " ) T"
				+ " WHERE YEAR_NEXT - YEAR IS NOT NULL"
				+ " AND  YEAR_NEXT - YEAR = ( SELECT MIN(YEARS_DIFF) FROM ("
				+ " SELECT YEAR_NEXT - YEAR AS YEARS_DIFF FROM ("
				+ " SELECT M.YEAR, LEAD(M.YEAR)  OVER (PARTITION BY MP.PRODUCER ORDER BY M.YEAR) AS YEAR_NEXT, MP.PRODUCER"
				+ " 				FROM MOVIES AS M INNER JOIN MOVIES_PRODUCERS AS MP"
				+ " 						ON M.ID = MP.ID_MOVIE"
				+ " 				 WHERE M.WINNER = true"
				+ " 				 ORDER BY MP.PRODUCER, M.YEAR"
				+ " ) T"
				+ " WHERE YEAR_NEXT - YEAR IS NOT NULL"
				+ " ORDER BY YEAR_NEXT - YEAR))"
				+ " ORDER BY YEAR_NEXT - YEAR";
		
		ResultSet rs = dbConn.execQuery(conn, sql);
		
		while (rs.next()) {
			Premiados premiados = new Premiados(rs.getString(4), rs.getInt(1), rs.getInt(2), rs.getInt(3));
			premiadosList.add(premiados);
		}
	
		return premiadosList;
	}
	
	public ArrayList<Premiados> getMaxPremiados() throws Exception {
		
    	DBConnection dbConn = new DBConnection();
    	Connection conn = DBConnection.getConnection();
    	
		ArrayList<Premiados> premiadosList = new ArrayList<Premiados>();
		
		String sql = "SELECT YEAR_NEXT - YEAR AS YEARS_DIFF, YEAR, YEAR_NEXT, PRODUCER FROM ("
				+ " SELECT M.YEAR, LEAD(M.YEAR)  OVER (PARTITION BY MP.PRODUCER ORDER BY M.YEAR) AS YEAR_NEXT, MP.PRODUCER"
				+ " 				FROM MOVIES AS M INNER JOIN MOVIES_PRODUCERS AS MP"
				+ " 						ON M.ID = MP.ID_MOVIE"
				+ " 				 WHERE M.WINNER = true"
				+ " 				 ORDER BY MP.PRODUCER, M.YEAR"
				+ " ) T"
				+ " WHERE YEAR_NEXT - YEAR IS NOT NULL"
				+ " AND  YEAR_NEXT - YEAR = ( SELECT MAX(YEARS_DIFF) FROM ("
				+ " SELECT YEAR_NEXT - YEAR AS YEARS_DIFF FROM ("
				+ " SELECT M.YEAR, LEAD(M.YEAR)  OVER (PARTITION BY MP.PRODUCER ORDER BY M.YEAR) AS YEAR_NEXT, MP.PRODUCER"
				+ " 				FROM MOVIES AS M INNER JOIN MOVIES_PRODUCERS AS MP"
				+ " 						ON M.ID = MP.ID_MOVIE"
				+ " 				 WHERE M.WINNER = true"
				+ " 				 ORDER BY MP.PRODUCER, M.YEAR"
				+ " ) T"
				+ " WHERE YEAR_NEXT - YEAR IS NOT NULL"
				+ " ORDER BY YEAR_NEXT - YEAR))"
				+ " ORDER BY YEAR_NEXT - YEAR";
		
		ResultSet rs = dbConn.execQuery(conn, sql);
		
		while (rs.next()) {
			Premiados premiados = new Premiados(rs.getString(4), rs.getInt(1), rs.getInt(2), rs.getInt(3));
			premiadosList.add(premiados);
		}
	
		return premiadosList;
	}

}

package com.iperrota.graapi.model;

public class Movie {
	
	private int id;
	private int year;
	private String title;
	private String[] studios;
	private String[] producers;
	private boolean winner;
	
	public Movie(int id, int year, String title, String[] studios, String[] producers, boolean winner) {
		this.id = id;
		this.year = year;
		this.title = title;
		this.studios = studios;
		this.producers = producers;
		this.winner = winner;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String[] getStudios() {
		return studios;
	}
	
	public void setStudios(String[] studios) {
		this.studios = studios;
	}
	
	public String[] getProducers() {
		return producers;
	}
	
	public void setProducers(String[] producers) {
		this.producers = producers;
	}
	
	public boolean isWinner() {
		return winner;
	}
	
	public void setWinner(boolean winner) {
		this.winner = winner;
	}

}

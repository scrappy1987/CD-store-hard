package com.qa.cdstore.model;

import javax.persistence.*;

@Entity
public class CD {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String artist;
	private String song;
	private String genre;
	
	public CD() {
		
	}
	
	public CD(String artist, String song, String genre) {
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}
	
	public Long getID() {
		return id;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}

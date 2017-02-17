package com.qa.cdstore.model;

import javax.persistence.*;

@Entity
public class CD {
	
	@Id
	private Long id;
	private String artist;
	private String song;
	private String genre;
	
	public CD() { 
	}
	
	public CD(long id, String artist, String song, String genre) {
		super();
		this.id = id;
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

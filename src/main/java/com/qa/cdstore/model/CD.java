package com.qa.cdstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CD {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max=250)
	private String artist;
	
	@NotNull
	@Size(max=250)
	private String song;
	
	@NotNull
	@Size(max=250)
	private String genre;
	
	public CD() {
		
	}
	
	public CD (int id, String artist, String song, String genre) {
		this.id = id;
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}
	
	public CD (String artist, String song, String genre) {
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

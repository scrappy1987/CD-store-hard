package com.qa.cdstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CD {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="artist")
	@NotNull
	private String artist;
	
	@Column(name="song")
	@NotNull
	private String song;
	
	@Column(name="genre")
	@NotNull
	private String genre;
	
	public CD() {
		
	}
	
	public CD(int id, String artist, String song, String genre) {
		
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

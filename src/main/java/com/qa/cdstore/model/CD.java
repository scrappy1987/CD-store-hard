package com.qa.cdstore.model;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CD {

	//Variables
	@Id
	@GeneratedValue
	@Column(name = "cdId")
	private int id;
	
	@NotNull
	private String artist;
	
	/*@NotNull
	private HashMap <Integer, String> songs = new HashMap<>();*/
	
	@NotNull
	private String song;
	
	/*@NotNull
	private int noOfTracks;*/
	
	private String genre; //Not every song needs a genre.
	
	//Constructors
	public CD(int id, String artist, String song, String genre){
		this.id = id;
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}

	/*public CD(int id, String artist, int noOfTracks, String genre){
		this.id = id;
		this.artist = artist;
		this.noOfTracks = noOfTracks;
		this.genre = genre;
	}*/
	
	//Getters and Setters
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

	/*public HashMap<Integer, String> getSongs() {
		songs.put(0, "Live and Let Die");
		songs.put(1, "Hey Jude");
		return songs;
	}*/
	
	/*public void setSongs(HashMap<Integer, String> songs) {
	this.songs = songs;
}*/

	public String getSong(){
		return song;
	}
	
	public void setSon(String song){
		this.song = song;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	/*public int getNoOfTracks() {
		return noOfTracks;
	}

	public void setNoOfTracks(int noOfTracks) {
		this.noOfTracks = noOfTracks;
	}*/
}

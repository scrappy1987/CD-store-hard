package com.qa.cdstore.model;

import javax.persistence.*;

@Entity
public class CD{
	@Id
	private Long cdID;
	
	private String cdArtist;
	private String cdSong;
	private String cdGenre;
	
	public CD(){}
	public CD(Long ID, String Artist, String Song, String Genre){
		setID(ID);
		setCdArtist(Artist);
		setCdSong(Song);
		setCdGenre(Genre);
	}
	
	public Long getID() {
		return cdID;
	}
	public void setID(Long iD) {
		cdID = iD;
	}
	public String getCdArtist() {
		return cdArtist;
	}
	public void setCdArtist(String cdArtist) {
		this.cdArtist = cdArtist;
	}
	public String getCdSong() {
		return cdSong;
	}
	public void setCdSong(String cdSong) {
		this.cdSong = cdSong;
	}
	public String getCdGenre() {
		return cdGenre;
	}
	public void setCdGenre(String cdGenre) {
		this.cdGenre = cdGenre;
	}
}
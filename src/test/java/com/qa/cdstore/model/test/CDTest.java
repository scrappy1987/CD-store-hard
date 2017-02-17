package com.qa.cdstore.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.cdstore.model.CD;

public class CDTest {
	
	CD testBlankCD = new CD();
	CD testNamedCD = new CD("Adele","25","Pop");

	/*@Test
	public void testGetID() {
		long id = testNamedCD.getID();
		//System.out.println(id);
		assertEquals(id, 0);
	}*/
	
	@Test
	public void testSetArtist() {
		testBlankCD.setArtist("The Beatles");
		String artist = testBlankCD.getArtist();
		//System.out.println(artist);
		assertEquals(artist,"The Beatles");
	}
	
	@Test
	public void testGetArtist() {
		String artist = testNamedCD.getArtist();
		//System.out.println(artist);
		assertEquals(artist,"Adele");
	}
	
	@Test
	public void testSetSong() {
		testBlankCD.setSong("Sgt. Pepper's Lonely Hearts Club Band");
		String song = testBlankCD.getSong();
		//System.out.println(song);
		assertEquals(song,"Sgt. Pepper's Lonely Hearts Club Band");
	}
	
	@Test
	public void testGetSong() {
		String song = testNamedCD.getSong();
		//System.out.println(id);
		assertEquals(song,"25");
	}
	
	@Test
	public void testSetGenre() {
		testBlankCD.setGenre("Rock");
		String genre = testBlankCD.getGenre();
		//System.out.println(id);
		assertEquals(genre,"Rock");
	}

	
	@Test
	public void testGetGenre() {
		String genre = testNamedCD.getGenre();
		//System.out.println(id);
		assertEquals(genre,"Pop");
	}

}

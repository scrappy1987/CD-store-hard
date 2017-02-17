package com.qa.cdstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.cdstore.model.CD;

public class CDTest {

	@Test
	public void testCDIntStringStringString() {
		CD cd = new CD(0, "Artist", "Song", "Genre");
		assertNotNull(cd);
		assertEquals("Artist", cd.getArtist());
		assertEquals("Song", cd.getSong());
		assertEquals("Genre", cd.getGenre());
	}

	@Test
	public void testCDStringStringString() {
		CD cd = new CD("Artist", "Song", "Genre");
		assertNotNull(cd);
		assertEquals("Artist", cd.getArtist());
		assertEquals("Song", cd.getSong());
		assertEquals("Genre", cd.getGenre());
	}

	@Test
	public void testGetId() {
		CD cd = new CD(0, "Artist", "Song", "Genre");
		assertEquals(0, cd.getId());
	}

	@Test
	public void testSetId() {
		CD cd = new CD(0, "Artist", "Song", "Genre");
		cd.setId(1);
		assertEquals(1, cd.getId());
	}

	@Test
	public void testGetArtist() {
		CD cd = new CD("Artist", "Song", "Genre");
		assertEquals("Artist", cd.getArtist());
	}

	@Test
	public void testSetArtist() {
		CD cd = new CD("Artist", "Song", "Genre");
		cd.setArtist("Artist!");
		assertEquals("Artist!", cd.getArtist());
	}

	@Test
	public void testGetSong() {
		CD cd = new CD("Artist", "Song", "Genre");
		assertEquals("Song", cd.getSong());
	}

	@Test
	public void testSetSong() {
		CD cd = new CD("Artist", "Song", "Genre");
		cd.setSong("Song!");
		assertEquals("Song!", cd.getSong());
	}

	@Test
	public void testGetGenre() {
		CD cd = new CD("Artist", "Song", "Genre");
		assertEquals("Genre", cd.getGenre());
	}

	@Test
	public void testSetGenre() {
		CD cd = new CD("Artist", "Song", "Genre");
		cd.setGenre("Genre!");
		assertEquals("Genre!", cd.getGenre());
	}

}

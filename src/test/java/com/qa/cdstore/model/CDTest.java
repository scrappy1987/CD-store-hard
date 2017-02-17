package com.qa.cdstore.model;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CDTest {

	@Test
	public void testGetArtist() {
		CD cd = new CD();
		cd.setArtist("Ed Sheeran");
		Assert.assertEquals("Ed Sheeran", cd.getArtist());
	}

	@Test
	public void testGetSongs() {
		Map<Integer, String> songs = new HashMap<Integer, String>();
		songs.put(1, "song 1");
		songs.put(2, "song 2");
		songs.put(3, "song 3");
		CD cd = new CD();
		cd.setSongs(songs);
		Assert.assertEquals(3, cd.getSongs().size());

	}

	@Test
	public void testGetGenre() {
		CD cd = new CD();
		cd.setGenre("Pop Music");
		Assert.assertEquals("Pop Music", cd.getGenre());
	}
}

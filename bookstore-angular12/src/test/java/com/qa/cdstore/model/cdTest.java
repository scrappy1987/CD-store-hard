package com.qa.cdstore.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.cdstore.model.CD;

public class cdTest
{	
	@Test
	public void testGetters()
	{
		CD testCD = new CD("Nightwish", "Nemo", "Metal");
		assertEquals(testCD.getArtist(),"Nightwish");
		assertEquals(testCD.getSong(),"Nemo");
		assertEquals(testCD.getGenre(),"Metal");
	}
	
	@Test
	public void testsetters()
	{
		CD testCD = new CD("Nightwish", "Nemo", "Metal");
		assertEquals(testCD.getArtist(),"Nightwish");
		assertEquals(testCD.getSong(),"Nemo");
		assertEquals(testCD.getGenre(),"Metal");
		testCD.setArtist("Alestorm");
		testCD.setSong("Wenches and Mead");
		testCD.setGenre("Pirate Metal");
		assertEquals(testCD.getArtist(),"Alestorm");
		assertEquals(testCD.getSong(),"Wenches and Mead");
		assertEquals(testCD.getGenre(),"Pirate Metal");
	}
}

package com.qa.cdstore.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CDTest {

	@Test
	public void testGetArtist() {
		CD cd = new CD("nightmares on wax","les nuits","electronica");
		String assertion = cd.getArtist();
		assertEquals(assertion,"nightmares on wax");		
	}

	
}

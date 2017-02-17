package com.qa.cdstore.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.service.CDServices;

public class CDServiceTest
{	
	@Test
	public void testGet()
	{
		CDServices service = new CDServices(true, false);
		String actualJson = service.getCDs();
		String expectedJson = "{\"1\":{\"artist\":\"Nightwish\",\"song\":\"Nemo\",\"genre\":\"Metal\"},\"2\":{\"artist\":\"Alestorm\",\"song\":\"Wenches and Mead\",\"genre\":\"Pirate Metal\"},\"3\":{\"artist\":\"Angerfist\",\"song\":\"Spook\",\"genre\":\"Hardstyle\"},\"4\":{\"artist\":\"Kamelot\",\"song\":\"March of Mephisto\",\"genre\":\"Metal\"}}";
		assertEquals(actualJson,expectedJson);
	}
	
	@Test
	public void testAdd()
	{
		String actualJson;
		String expectedJson;

		CDServices service = new CDServices(true, true);
		actualJson = service.getCDs();
		expectedJson = "{1\":{\"artist\":\"Nightwish\",\"song\":\"Nemo\",\"genre\":\"Metal\"},\"2\":{\"artist\":\"Alestorm\",\"song\":\"Wenches and Mead\",\"genre\":\"Pirate Metal\"},\"3\":{\"artist\":\"Angerfist\",\"song\":\"Spook\",\"genre\":\"Hardstyle\"},\"4\":{\"artist\":\"Kamelot\",\"song\":\"March of Mephisto\",\"genre\":\"Metal\"}}";
		assertEquals(actualJson,expectedJson);
		
		String newCD = "{\"artist\":\"New Artist\",\"song\":\"New Song\",\"genre\":\"New Genre\"}";
		service.addCD(newCD);
		actualJson = service.getCDs();
		expectedJson = "{\"1\":{\"artist\":\"Nightwish\",\"song\":\"Nemo\",\"genre\":\"Metal\"},\"2\":{\"artist\":\"Alestorm\",\"song\":\"Wenches and Mead\",\"genre\":\"Pirate Metal\"},\"3\":{\"artist\":\"Angerfist\",\"song\":\"Spook\",\"genre\":\"Hardstyle\"},\"4\":{\"artist\":\"Kamelot\",\"song\":\"March of Mephisto\",\"genre\":\"Metal\"},\"5\":{\"artist\":\"New Artist\",\"song\":\"New Song\",\"genre\":\"New Genre\"}}";
		assertEquals(actualJson,expectedJson);
	}
	
	@Test
	public void testUpdate()
	{
		CDServices service = new CDServices(true, false);

	}
	
	@Test
	public void testDelete()
	{
		CDServices service = new CDServices(true, false);

	}
}

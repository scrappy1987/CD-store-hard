package com.qa.cdstore.util;

import org.junit.Assert;
import org.junit.Test;
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

public class JSONUtilTest
{
	@Test
	public void testObjectToString()
	{
		JSONUtil converter = new JSONUtil();
		CD testCD = new CD("Nightwish", "Nemo", "Metal");
		String cdString = converter.getJSONFfromEntity(testCD);
		String output = "{\"artist\":\"Nightwish\",\"song\":\"Nemo\",\"genre\":\"Metal\"}";
		Assert.assertEquals(output, cdString);
	}

	@Test
	public void testStringToObject()
	{
		JSONUtil converter = new JSONUtil();
		String cdString = "{\"artist\":\"Nightwish\",\"song\":\"Nemo\",\"genre\":\"Metal\"}";
		CD cdObject = converter.getEntityFromJSON(cdString, CD.class);
		Assert.assertEquals(cdObject.getArtist(), "Nightwish");
		Assert.assertEquals(cdObject.getSong(), "Nemo");
	}
}

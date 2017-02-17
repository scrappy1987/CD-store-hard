package com.qa.cdstore.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

public class JSONUtilTest {
	
	private JSONUtil jutil;
	private CD testCd;

	@Before
	public void init() {
		jutil = new JSONUtil();
		testCd = new CD("Stephen King", "IT", "Horror");
	}

	@Test
	public void testCDIsConvertedToJSONCorrectly() {
		String cdToJson = jutil.getJSONForObject(testCd);
		String assertionString = "{\"artist\":\"Stephen King\",\"song\":\"IT\",\"genre\":\"Horror\"}";
		Assert.assertEquals(assertionString, cdToJson);
	}

	@Test
	public void testJsonIsConvertedToCDCorrectly() {
		String cdString = "{\"artist\":\"Stephen King\",\"song\":\"IT\",\"genre\":\"Horror\"}";
		CD jsonToCd = jutil.getObjectForJSON(cdString, CD.class);
		Assert.assertEquals(jsonToCd.getArtist(), "Stephen King");
		Assert.assertEquals(jsonToCd.getSong(), "IT");
	}
}

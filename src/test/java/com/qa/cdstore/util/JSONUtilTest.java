package com.qa.cdstore.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.cdstore.model.CD;

import junit.framework.Assert;

public class JSONUtilTest {
	
	private JSONUtil util = new JSONUtil();
	private CD cd = new CD(1, "One Direction", "History","Pop");

	
	@Test
	public void testCDsAreConvertedToJSON() {
		String cdToJson = util.getJSONForObject(cd);
		String assertionString = "{\"artist\":\"One Direction\",\"song\":\"History\", \"genre\":\"Pop\"}";
		assertEquals(assertionString, cdToJson);
	}
	
	@Test
	public void testJsonCD() {
		String cdString = "{\"artist\":\"One Direction\",\"History\",\"genre\":\"Pop\"}";
		CD jsonToCD = util.getObjectForJSON(cdString,CD.class);
		assertEquals(jsonToCD.getArtist(),"One Direction");
		assertEquals(jsonToCD.getSong(),"History");
	}

}

package com.qa.cdstore.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.rest.CDEndpoint;
import com.qa.cdstore.rest.JAXActivator;
import com.qa.cdstore.service.CDServiceImpl;
import com.qa.cdstore.service.DBCDServiceImp;
import com.qa.cdstore.util.JSONUtil;

/*
@Default
@Stateless
public class MAPCDServiceImp {

	@Inject
	private TestData testData; //doesn't exist as of yet
	
	@Override
	public CD readCD(int cdId)
	
}
*/
package com.qa.cdstore.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public interface CDService {
	
	public String getAllCDs();
	
	public String addNewCD(String cdJson);
	
	public String replaceCD(Integer id, String updatedCD);
	
	public String deleteCD(Integer id);


}

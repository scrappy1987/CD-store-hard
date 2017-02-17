package com.qa.cdstore.service;

public interface CDService {

	public String getAllCds();
	
	public String getSingleCD(int id);
	
	public String deleteCD(int id);
	
	public String addCD(String objJSON);
	
	public String updateCD(int id, String objSJON);
}

package com.qa.cdstore.service;

public interface CDService {

	public String getAllCDs();
	
	public String getSingleCD(int id);
	
	public String deleteCD(int id);
	
	public String addNewCD(String jsonCD);
	
	public String updateCD(Integer cdId, String updateCD);
}

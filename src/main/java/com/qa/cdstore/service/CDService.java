package com.qa.cdstore.service;

public interface CDService {
	
	public String addCD(String json);
	
	public String updateCD(int id, String json);
	
	public String removeCD(int id);
	
	public String getAllCDs();
	
	public String getCD(int id);
}

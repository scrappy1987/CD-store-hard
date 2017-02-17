package com.qa.cdstore.service;

public interface CDService {
	public String getAllCDs();
	public String getSingleCD(Integer id);
	public String addnewCD(String cd);
	public String updateCD(Integer id, String cd);
	public String deleteCD(Integer id);
}

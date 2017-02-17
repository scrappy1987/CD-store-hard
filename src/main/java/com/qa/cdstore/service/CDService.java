package com.qa.cdstore.service;

public interface CDService{
	String getAllCDs();
	String addNewCD(String cdJSON);
	String replaceCD(Integer Key, String cdUpdate);
	String deleteCD(Integer Key);
}
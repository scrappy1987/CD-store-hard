package com.qa.cdstore.service;

public class DBWrapper{
	private String dbHost;
	private String dbPort;
	public String dbName;
	private String dbUSR;
	private String dbPWD;
	
	private String dbConnectionURL;
	
	public DBWrapper(){
		setDbHost("sql8.freesqldatabase.com");
		setDbPort("3306");
		setDbName("sql8159413");
		setDbUSR("sql8159413");
		setDbPWD("RYZW2Z9iTf");
		
		Init();
	}
	
	public String getDbHost() {
		return dbHost;
	}
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbName(){
		return dbName;
	}
	public void setDbName(String dbName){
		this.dbName = dbName;
	}
	public String getDbUSR() {
		return dbUSR;
	}
	public void setDbUSR(String dbUSR) {
		this.dbUSR = dbUSR;
	}
	public String getDbPWD() {
		return dbPWD;
	}
	public void setDbPWD(String dbPWD) {
		this.dbPWD = dbPWD;
	}
	
	public void Init(){
		dbConnectionURL = "jdbc:mysql://"+getDbHost()+":"+getDbPort()+"/"+getDbName();
	}
	
	public String ConnectionURL(){
		return dbConnectionURL;
	}
	

	
}
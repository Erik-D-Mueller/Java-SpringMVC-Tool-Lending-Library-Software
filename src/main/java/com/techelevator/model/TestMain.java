package com.techelevator.model;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestMain {
	
	
	public static void main(String[] args) {

		ToolDAO test;
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("postgres");
		
		test = new JDBCToolDAO(dataSource);
		
		test.getAllTools();
		
	}

}

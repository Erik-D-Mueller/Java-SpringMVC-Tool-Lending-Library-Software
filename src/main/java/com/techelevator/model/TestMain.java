package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.domain.Reservation;
import com.techelevator.model.jdbc.JDBCReservationDAO;
import com.techelevator.model.jdbc.JDBCToolDAO;

public class TestMain {
	
	
	public static void main(String[] args) {

		ToolDAO test;
		ReservationDAO test2;
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("postgres");
		
		test = new JDBCToolDAO(dataSource);
		
//		List<Tool> testList = new ArrayList<>();
//		testList = test.getAllAvailableTools();
//		
//		for(Tool e: testList) {
//			System.out.println(e.getToolId());
//		}
		
		test2 = new com.techelevator.model.jdbc.JDBCReservationDAO(dataSource);
		
		List<Reservation> testList = new ArrayList<>();
		testList = test2.searchToolsByToolNumber(1);
		
		for(Reservation e: testList) {
			System.out.println(e.getToolId());
			System.out.println(e.getToolName());
			System.out.println(e.getName());
			System.out.println(e.getDateOut());
			System.out.println(e.getDateIn());
		}
		
		testList = test2.searchToolsByName("Erik");
		
		for(Reservation e: testList) {
			System.out.println(e.getToolId());
			System.out.println(e.getToolName());
			System.out.println(e.getName());
			System.out.println(e.getDateOut());
			System.out.println(e.getDateIn());
		}
		
		testList = test2.searchToolsByDriversLicense("DD123456");
		
		for(Reservation e: testList) {
			System.out.println(e.getToolId());
			System.out.println(e.getToolName());
			System.out.println(e.getName());
			System.out.println(e.getDateOut());
			System.out.println(e.getDateIn());
		}
	}

}

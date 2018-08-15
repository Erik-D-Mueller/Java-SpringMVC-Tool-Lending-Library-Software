package com.techelevator.model.domain;

import java.util.List;

public class Member {
	
	private int memberId;
	private String userName;
	private List<Reservation> listOfReservations;
	
	public List<Reservation> getListOfReservations() {
		return listOfReservations;
	}
	public void setListOfReservations(List<Reservation> listOfReservations) {
		this.listOfReservations = listOfReservations;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

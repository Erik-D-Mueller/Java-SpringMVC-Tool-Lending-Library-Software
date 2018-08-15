package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.domain.Reservation;

public interface ReservationDAO {

	public List<Reservation> searchToolsByName(String userName);
	
	public List<Reservation> searchToolsByDriversLicense(String driversLicense);

	public List<Reservation> searchToolsByToolNumber(int toolId);

}

package com.techelevator.model;

import java.util.List;

public interface ReservationDAO {

	public List<Reservation> searchToolsByName(String userName);
	
	public List<Reservation> searchToolsByDriversLicense(String driversLicense);

	public List<Reservation> searchToolsByToolNumber(int toolId);
	
	public List<Reservation> getAllCheckedOutTools();

}

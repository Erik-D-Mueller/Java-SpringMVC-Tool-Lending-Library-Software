package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.domain.Reservation;
import com.techelevator.model.domain.ShoppingCart;

public interface ReservationDAO {

	public List<Reservation> searchToolsByName(String userName);
	
	public List<Reservation> searchToolsByDriversLicense(String driversLicense);

	public List<Reservation> searchToolsByToolNumber(int toolId);
	
	public List<Reservation> getAllCheckedOutTools();

	public int saveNewReservation(ShoppingCart cart, int memberId);
	
	public void deleteReservation(int toolId);

	public List<Reservation> searchReservationsByReservationNumber(int reservationId);
}

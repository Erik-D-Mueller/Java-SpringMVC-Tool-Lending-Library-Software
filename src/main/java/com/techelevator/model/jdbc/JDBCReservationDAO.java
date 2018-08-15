package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.domain.Reservation;

@Component
public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Reservation> searchToolsByName(String userName) {

		List<Reservation> searchToolsByName = new ArrayList<>();

		LocalDate date = LocalDate.now();

		String sqlSearchToolsByName = "SELECT t.tool_id, tt.tool_name, au.user_name, r.from_date, r.to_date "
				+ "FROM app_user au " + "JOIN reservation r ON r.app_user_id = au.app_user_id "
				+ "JOIN tool_reservation tr ON r.reservation_id = tr.reservation_id "
				+ "JOIN tool t ON tr.tool_id = t.tool_id " + "JOIN tool_type tt ON t.tool_type_id = tt.tool_type_id "
				+ "WHERE au.user_name = ? "
				+ "AND (to_date(?, 'YYYY/MM/DD')) <= r.to_date AND (to_date(?, 'YYYY/MM/DD')) >= r.from_date";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchToolsByName, userName.toUpperCase(), date.toString(),
				date.toString());

		while (results.next()) {
			Reservation theReservation = mapRowToReservation(results);
			searchToolsByName.add(theReservation);
		}
		return searchToolsByName;
	}

	@Override
	public List<Reservation> searchToolsByDriversLicense(String driversLicense) {

		List<Reservation> searchToolsByDriversLicense = new ArrayList<>();

		LocalDate date = LocalDate.now();

		String sqlSearchToolsByDriversLicense = "SELECT t.tool_id, tt.tool_name, au.user_name, r.from_date, r.to_date "
				+ "FROM app_user au " + "JOIN reservation r ON r.app_user_id = au.app_user_id "
				+ "JOIN tool_reservation tr ON r.reservation_id = tr.reservation_id "
				+ "JOIN tool t ON tr.tool_id = t.tool_id " + "JOIN tool_type tt ON t.tool_type_id = tt.tool_type_id "
				+ "WHERE au.drivers_license = ? "
				+ "AND (to_date(?, 'YYYY/MM/DD')) <= r.to_date AND (to_date(?, 'YYYY/MM/DD')) >= r.from_date";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchToolsByDriversLicense, driversLicense, date.toString(),
				date.toString());

		while (results.next()) {
			Reservation theReservation = mapRowToReservation(results);
			searchToolsByDriversLicense.add(theReservation);
		}
		return searchToolsByDriversLicense;
	}

	@Override
	public List<Reservation> searchToolsByToolNumber(int toolId) {

		List<Reservation> searchToolsByToolNumber = new ArrayList<>();

		LocalDate date = LocalDate.now();

		String sqlSearchToolsByToolNumber = "SELECT t.tool_id, tt.tool_name, au.user_name, r.from_date, r.to_date "
				+ "FROM app_user au " + "JOIN reservation r ON r.app_user_id = au.app_user_id "
				+ "JOIN tool_reservation tr ON r.reservation_id = tr.reservation_id "
				+ "JOIN tool t ON tr.tool_id = t.tool_id " + "JOIN tool_type tt ON t.tool_type_id = tt.tool_type_id "
				+ "WHERE t.tool_id = ? "
				+ "AND (to_date(?, 'YYYY/MM/DD')) <= r.to_date AND (to_date(?, 'YYYY/MM/DD')) >= r.from_date";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchToolsByToolNumber, toolId, date.toString(),
				date.toString());

		while (results.next()) {
			Reservation theReservation = mapRowToReservation(results);
			searchToolsByToolNumber.add(theReservation);
		}
		return searchToolsByToolNumber;
	}
	
	@Override
	public List<Reservation> getAllCheckedOutTools(){
		
		List<Reservation> searchForCheckedOutTools = new ArrayList<>();
		
		LocalDate date = LocalDate.now();
	
		String sqlSearchCheckedOutTools = "SELECT t.tool_id, tt.tool_name, au.user_name, r.from_date, r.to_date "
				+ "FROM app_user au " + "JOIN reservation r ON r.app_user_id = au.app_user_id "
				+ "JOIN tool_reservation tr ON r.reservation_id = tr.reservation_id "
				+ "JOIN tool t ON tr.tool_id = t.tool_id " + "JOIN tool_type tt ON t.tool_type_id = tt.tool_type_id "
				+ "AND (to_date(?, 'YYYY/MM/DD')) <= r.to_date AND (to_date(?, 'YYYY/MM/DD')) >= r.from_date "
				+ "ORDER BY t.tool_id";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchCheckedOutTools, date.toString(),
				date.toString());
		
		while (results.next()) {
			Reservation theReservation = mapRowToReservation(results);
			searchForCheckedOutTools.add(theReservation);
		}
		return searchForCheckedOutTools;
	}

	public Reservation mapRowToReservation(SqlRowSet results) {

		Reservation newReservation = new Reservation();

		newReservation.setToolId(results.getInt("tool_id"));
		newReservation.setName(results.getString("user_name"));
		newReservation.setToolName(results.getString("tool_name"));
		newReservation.setDateOut(results.getString("to_date"));
		newReservation.setDateIn(results.getString("from_date"));

		return newReservation;
	}

}

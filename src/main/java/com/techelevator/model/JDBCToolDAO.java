package com.techelevator.model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCToolDAO implements ToolDAO {

	private JdbcTemplate jdbcTemplate;
	private Date date;

	@Autowired
	public JDBCToolDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Tool> getAllTools(){
		
		List<Tool> listOfAllTools = new ArrayList<>();
		
		String sqlListAllTools = "SELECT t.tool_id, tt.tool_name, tt.tool_description "
								+ "FROM tool t JOIN tool_type tt ON tt.tool_type_id = t.tool_type_id ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllTools);
		
		while(results.next()) {
			Tool theTool = mapRowToTool(results);
			listOfAllTools.add(theTool);
		}
		return listOfAllTools;
	}
	
	@Override
	public List<Tool> getAllAvailableTools(){
		
		List<Tool> listOfAvailableTools = new ArrayList<>();
		
		LocalDate date = LocalDate.now();
		date.toString();
		
		String sqlListAllTools = "SELECT t.tool_id, tt.tool_name, tt.tool_description "
								+"FROM tool t JOIN tool_type tt ON tt.tool_type_id = t.tool_type_id "
								+"WHERE t.tool_id NOT IN "
								+"(SELECT t.tool_id "
								+"FROM tool t JOIN tool_reservation tr ON t.tool_id = tr.tool_id "
								+"JOIN reservation r ON r.reservation_id = tr.reservation_id "
								+"WHERE ((to_date(?, 'YYYY/MM/DD')) <= r.to_date AND (to_date(?, 'YYYY/MM/DD')) >= r.from_date))";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllTools, date.toString(), date.toString());
		
		while(results.next()) {
			Tool theTool = mapRowToTool(results);
			listOfAvailableTools.add(theTool);
		}
		return listOfAvailableTools;	
		
	}
	
	public Tool mapRowToTool(SqlRowSet results) {
		
		Tool newTool = new Tool();
		
		newTool.setToolId(results.getInt("tool_id"));
		newTool.setName(results.getString("tool_name"));
		newTool.setDescription(results.getString("tool_description"));
							
		return newTool;
	}
}

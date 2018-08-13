package com.techelevator.model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		String sqlListAllTools = "SELECT t.tool_id, tt.tool_name, tt.tool_description, r.to_date, r.from_date "
								+ "FROM tool t JOIN tool_type tt ON tt.tool_type_id = t.tool_type_id "
								+ "JOIN tool_reservation tr ON t.tool_id = tr.tool_id "
								+ "JOIN reservation r ON r.reservation_id = tr.reservation_id";
		
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
		
		String sqlListAllTools = "SELECT * FROM tool t JOIN tool_type tt ON t.tool_type_id = tt.tool_type_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllTools);
		
		while(results.next()) {
			Tool theTool = mapRowToTool(results);
			listOfAvailableTools.add(theTool);
		}
		return listOfAvailableTools;	
		
	}
	
	public Tool mapRowToTool(SqlRowSet results) {
		
		Tool newTool = new Tool();
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		try {
			date = simpleDateFormat.parse(results.getString("to_date"));
		} catch (InvalidResultSetAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newTool.setToolId(results.getInt("tool_id"));
		newTool.setName(results.getString("tool_name"));
		newTool.setDescription(results.getString("tool_description"));
					
		System.out.println(date);
		
		return newTool;
	}
}

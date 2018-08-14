package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.JDBCToolDAO;
import com.techelevator.model.Tool;
import com.techelevator.model.ToolDAO;

public class ToolDAOIntegrationTest extends DAOIntegrationTest {

	private DataSource dataSource;
	private ToolDAO test;
	private JdbcTemplate jdbcTemplate;

	private final int TEST_TOOL_TYPE_ID = 99999;
	private final String TEST_TOOL_NAME = "TEST";
	private final String TEST_TOOL_DESCRIPTION = "THIS IS A TEST TOOL";
	private final int TEST_TOOL_ID = 99999;
	private final int TEST_RESERVATION_ID = 99999;

	@Before
	public void setup() {

		dataSource = super.getDataSource();
		test = new JDBCToolDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);

		String newToolType = "INSERT INTO tool_type (tool_type_id, tool_name, tool_description) " + "VALUES (?, ?, ?)";

		String newTool = "INSERT INTO tool (tool_id, tool_type_id) " + "VALUES (?, ?)";

		String newReservation = "INSERT INTO reservation (reservation_id, app_user_id, from_date, to_date) "
				+ "VALUES (?, 3, NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days')";

		String reserveNewTool = "INSERT INTO tool_reservation (tool_id, reservation_id) " + "VALUES (?, ?)";

		jdbcTemplate.update(newToolType, TEST_TOOL_TYPE_ID, TEST_TOOL_NAME, TEST_TOOL_DESCRIPTION);
		jdbcTemplate.update(newTool, TEST_TOOL_TYPE_ID, TEST_TOOL_ID);
		jdbcTemplate.update(newReservation, TEST_RESERVATION_ID);
		jdbcTemplate.update(reserveNewTool, TEST_TOOL_ID, TEST_RESERVATION_ID);

	}

	@Test
	public void constructorTest() {

		JDBCToolDAO test2 = new JDBCToolDAO(dataSource);

		Assert.assertNotNull(test2);
	}

	@Test
	public void getAllToolsTest() {

		List<Tool> listOfAllTools = new ArrayList<>();
		listOfAllTools = test.getAllTools();

		Assert.assertNotNull(listOfAllTools);
		Assert.assertEquals(TEST_TOOL_ID, listOfAllTools.get(listOfAllTools.size() - 1).getToolId());
	}

	@Test
	public void getAllAvailableToolsTest() {

		List<Tool> listOfAvailableTools = new ArrayList<>();
		listOfAvailableTools = test.getAllAvailableTools();

		Assert.assertNotEquals(TEST_TOOL_ID, listOfAvailableTools.get(listOfAvailableTools.size() - 1).getToolId());
	}

}

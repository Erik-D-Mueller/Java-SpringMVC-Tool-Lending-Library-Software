package com.techelevator;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)      // This tells JUnit to use a special Spring enabled TestRunner, this allows us to use @Autowired
@ContextConfiguration("/test-config.xml")    // This tells Spring where to get it's configuration from
@Transactional   // by annotating a JUnit test as @Transactional, each test is wrapped in a transaction
public class IntegrationTestBase {
	
	@Autowired private BasicDataSource dataSource;   
	
	@After
	public final void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
}

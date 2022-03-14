package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@toy-oracle.cwkdq9ftbcnp.ap-northeast-2.rds.amazonaws.com:1521:ORACLE",
				"study_book_ex",
				"study_book_ex")) {
			log.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}

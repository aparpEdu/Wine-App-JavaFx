package JUnitTesting;

import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.Test;

import sqlconnection.LoginChecker;

public class criticalUnit {

	@Test
	public void testLogin() throws SQLException {
		LoginChecker lc = new LoginChecker();
		boolean res =  lc.check("Leonellus", "pass123");
		assertEquals(true,res);
		}
	}



package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCON {
	private static final String dbDriver="org.postgresql.Driver";
	private static final String dbUrl="jdbc:postgresql://localhost:5432/postgres";
	private static  String dbUsername="postgres";
	private static String dbPassword="dancho39";
	public JDBCON() {
		// TODO Auto-generated constructor stub
	}
	 public static Connection getConnection() throws SQLException {
	        try {
	            Class.forName(dbDriver);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	    }
	 public static void closeResources(Connection conn, Statement stmt) {
		    try {
		        if (stmt != null) {
		            stmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	 public static void closeResources(ResultSet result) {
		    try {
		        if (result != null) {
		        	result.close();
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}

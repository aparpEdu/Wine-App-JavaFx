package sqlconnection.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import sqlconnection.JDBCON;

public class SQLHelper {
	private static final String dbDriver="org.postgresql.Driver";
	private static final String dbUrl="jdbc:postgresql://localhost:5432/postgres";
	private static  String dbUsername="postgres";
	private static String dbPassword="dancho39";
	public SQLHelper() {
		
	}
	public static void insertData(String tableName, Map<String, Object> data) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();
	        StringBuilder columns = new StringBuilder();
	        StringBuilder values = new StringBuilder();
	        for (Map.Entry<String, Object> entry : data.entrySet()) {
	            columns.append(entry.getKey()).append(",");
	            values.append("?,");
	        }
	        columns.deleteCharAt(columns.length() - 1);
	        values.deleteCharAt(values.length() - 1);
	        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
	        stmt = conn.prepareStatement(sql);
	        int i = 1;
	        for (Map.Entry<String, Object> entry : data.entrySet()) {
	            stmt.setObject(i, entry.getValue());
	            i++;
	        }
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	
	public static void update(String tableName, Map<String, Object> data,String condition) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();
	        StringBuilder columns = new StringBuilder();
	        StringBuilder values = new StringBuilder();
	        StringBuilder newValues=new StringBuilder("");
//	        for (Map.Entry<String, Object> entry : data.entrySet()) {
//	            columns.append(entry.getKey()).append(",");
//	            values.append("?,");
//	        }
	        for(Map.Entry<String,Object> entry:data.entrySet())
	         {
	        	newValues.append(entry.getKey()+"="+"\'"+entry.getValue()+"\',");
	         }
//	        columns.deleteCharAt(columns.length() - 1);
//	        values.deleteCharAt(values.length() - 1);
	        newValues.deleteCharAt(newValues.length()-1);  
            String sql = "UPDATE " + tableName + " SET " + newValues + " WHERE username="+"\'"+condition+"\'" ;
	        stmt = conn.prepareStatement(sql);
//	        int i = 1;
//	        for (Map.Entry<String, Object> entry : data.entrySet()) {
//	            stmt.setObject(i, entry.getValue());
//	            i++;
//	        }
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	public static void delete(String tableName,String condition, String keyCondition) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();
	        StringBuilder columns = new StringBuilder();
	        StringBuilder values = new StringBuilder();
//	        for (Map.Entry<String, Object> entry : data.entrySet()) {
//	            columns.append(entry.getKey()).append(",");
//	            values.append("?,");
//	        }
//	        columns.deleteCharAt(columns.length() - 1);
//	        values.deleteCharAt(values.length() - 1);
	        String sql = "DELETE FROM "+tableName+" WHERE "+keyCondition+"="+"\'"+condition+"\'"  ;
	        stmt = conn.prepareStatement(sql);
	        int i = 1;
//	        for (Map.Entry<String, Object> entry : data.entrySet()) {
//	            stmt.setObject(i, entry.getValue());
//	            i++;
//	        }
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	public static void select(String tableName, Map<String, Object> data) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();
	        StringBuilder columns = new StringBuilder();
	        StringBuilder values = new StringBuilder();
	        for (Map.Entry<String, Object> entry : data.entrySet()) {
	            columns.append(entry.getKey()).append(",");
	            values.append("?,");
	        }
	        columns.deleteCharAt(columns.length() - 1);
	        values.deleteCharAt(values.length() - 1);
	        String sql = "SELECT " + tableName + " (" + columns + ") VALUES (" + values + ")";
	        stmt = conn.prepareStatement(sql);
	        int i = 1;
	        for (Map.Entry<String, Object> entry : data.entrySet()) {
	            stmt.setObject(i, entry.getValue());
	            i++;
	        }
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	
}

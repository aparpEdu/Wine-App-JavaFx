package sqlconnection.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import sqlconnection.JDBCON;

public class SQLHelper {
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
	public static void insertConditionData(ArrayList<String> data) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();
	        
	        
	        String sql = "WITH v AS (SELECT "+data.get(0)+" FROM "+data.get(2)+" WHERE "+data.get(5) +" =  '"+  data.get(7) +"')," +
                    "     v2 AS (SELECT "+data.get(1)+" FROM "+data.get(3)+" WHERE "+data.get(6)+" = '"+ data.get(8) +"')" +
                    "INSERT INTO "+data.get(4)+" ("+data.get(0)+", "+data.get(1)+") SELECT v."+data.get(0)+",  v2."+data.get(1)+ " FROM v, v2";
	        stmt = conn.prepareStatement(sql);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
//	public static void insertConditionData(String firstTable,String secondTable,String destTable, Map<String, Object> data,String keyCondition,String keyCondition2,String condition,String condition2,String column,String column2) {
//	    Connection conn = null;
//	    PreparedStatement stmt = null;
//	    try {
//	        conn = JDBCON.getConnection();
//	        
//	        
//	        String sql = "WITH v AS (SELECT "+column+" FROM "+firstTable+" WHERE "+keyCondition +" =  '"+  condition +"')," +
//                    "     v2 AS (SELECT "+column2+" FROM "+secondTable+" WHERE "+keyCondition2+" = '"+ condition2 +"')" +
//                    "INSERT INTO "+destTable+" ("+column+", "+column2+") SELECT v."+column+",  v2."+column2+ " FROM v, v2";
//	        stmt = conn.prepareStatement(sql);
//	        stmt.executeUpdate();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	    	JDBCON.closeResources(conn, stmt);
//	    }
//	}
	
	public static void update(String tableName, Map<String, Object> data,String condition,String keyCondition) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();

	        StringBuilder newValues=new StringBuilder("");
	        for(Map.Entry<String,Object> entry:data.entrySet())
	         {
	        	newValues.append(entry.getKey()+"="+"\'"+entry.getValue()+"\',");
	         }
	        newValues.deleteCharAt(newValues.length()-1);  
            String sql = "UPDATE " + tableName + " SET " + newValues + " WHERE " +keyCondition+"="+"\'"+condition+"\'" ;
	        stmt = conn.prepareStatement(sql);
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

	        String sql = "DELETE FROM "+tableName+" WHERE "+keyCondition+"="+"\'"+condition+"\'"  ;
	        stmt = conn.prepareStatement(sql);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	public static ResultSet select(String tableName,String condition,String keyCondition) {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            conn = JDBCON.getConnection();
            String sql = "SELECT * FROM "+tableName+" WHERE "+keyCondition+"="+"\'"+condition+"\'"  ;
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}

	public static ResultSet selectAllFromTable(String tableName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            conn = JDBCON.getConnection();
            String sql = "SELECT * FROM " + tableName;
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	public static ResultSet getCurrentDate() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            conn = JDBCON.getConnection();
            String sql = "SELECT CURRENT_DATE ";
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	
	
}

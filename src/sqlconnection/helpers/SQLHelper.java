package sqlconnection.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
	        	if(sqlConverter.doubleParser(entry.getValue()) == Types.NUMERIC) {
	        		
	        		stmt.setObject(i,sqlConverter.floatParse(entry.getValue()),Types.NUMERIC);
	        		
	        	}
	        	else {
	        		
	        		stmt.setObject(i, entry.getValue(),sqlConverter.doubleParser(entry.getValue()));
	        		
	        	}
	        
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
	public static void update(String tableName,String[] conditions,String column,String value,String[] keyConditions) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();

	        int i =0;
	        int j =0;
            String sql = "UPDATE " + tableName + " SET " + column + "="+value+" WHERE " +keyConditions[i]+" = "+"\'"+conditions[j]+"' AND "+ keyConditions[++i] + " = " +conditions[++j];
	        stmt = conn.prepareStatement(sql);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	public static void updateSelect(String tableName,String[] conditions,String column,String value,String[] keyConditions,String tableName2) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();

	        int i =0;
	        int j =0;
            String sql = "UPDATE " + tableName2 + " SET " + column + " = "+value+" WHERE " +keyConditions[i]+" = ( SELECT "+  keyConditions[i] +" FROM "+ tableName2 + " WHERE " +keyConditions[++i] +" = " + conditions[j] + " AND " +keyConditions[++i] + " = "+ conditions[++j] + " AND " + keyConditions[++i] + " = '"+ conditions[++j] +"' LIMIT 1);" ;
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
	public static void deleteSelect(String tableName,String condition,String keyCondition,String tableName2,String keyCondition2) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();

	        String sql = "DELETE FROM "+tableName+" WHERE "+keyCondition2+" = ( SELECT "+keyCondition2+" FROM "+tableName2+" WHERE "+keyCondition+" = "+"'"+condition+"' LIMIT 1);"  ;
	        stmt = conn.prepareStatement(sql);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCON.closeResources(conn, stmt);
	    }
	}
	public static void deleteSelects(String tableName,String condition,String keyCondition,String tableName2,String keyCondition2) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = JDBCON.getConnection();

	        String sql = "DELETE FROM "+tableName+" WHERE "+keyCondition2+" = ( SELECT "+keyCondition2+" FROM "+tableName2+" WHERE "+keyCondition+" = "+"\'"+condition+"\' );"  ;
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

	public static ResultSet selectAllWithJoin(String tableName, String[] joinTables, String[] joinConditions,String[] tables,String column,String column2,String[] tables2) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet result = null;
    try {
        conn = JDBCON.getConnection();
        String sql = "SELECT "+tables2[0]+"."+column+", "+ tables2[1]+"."+column2+" FROM "+tableName;
        for (int i = 0; i < joinTables.length; i++) {
            sql += " JOIN "+joinTables[i]+" ON "+tables[i]+"."+joinConditions[i]+" = "+joinTables[i]+"."+joinConditions[i];
        }
        
        stmt = conn.prepareStatement(sql);
        result = stmt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
    
}
	
	public static ResultSet selectWithJoin(String tableName, String condition, String keyCondition, String[] joinTables, String[] joinConditions, String joinType,String[] tables,String column,String column2,String[] tables2,String tableName2) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;
	    try {
	        conn = JDBCON.getConnection();
	        String sql =  "SELECT "+tables2[0]+"."+column+", "+ tables2[1]+"."+column2+" FROM "+tableName;
	        for (int i = 0; i < joinTables.length; i++) {
	            if(joinType.equalsIgnoreCase("condition1")){
	                sql += " JOIN "+joinTables[i]+" ON "+tables[i]+"."+joinConditions[i]+" = "+joinTables[i]+"."+joinConditions[i];
	            }else{
	            	sql += " JOIN "+joinTables[i]+" ON "+tables[i]+"."+joinConditions[i]+" = "+joinTables[i]+"."+joinConditions[i];
	            }
	        }
	        if(joinType.equalsIgnoreCase("condition1")){
	            sql += " WHERE "+tableName2+"."+keyCondition+" = \'"+condition+"\'";
	        }else{
	        	sql += " WHERE "+joinTables[joinTables.length-1]+"."+keyCondition+" = \'"+condition+"\'";
	        }
	        stmt = conn.prepareStatement(sql);
	        result = stmt.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}


	

	public static ResultSet selectWithJoin(String condition,String table,String table2,String table3) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet result = null;
	    try {
	        conn = JDBCON.getConnection();
	        String sql = "SELECT "+table+".username, "+table2+".storage_name FROM " +table +
	                    " JOIN "+table3+" ON "+table+".user_id = "+table3+".user_id" +
	                    " JOIN "+table2+" ON "+table2+".storage_id = "+table3+".storage_id" +
	                    " WHERE "+table+".username = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, condition);
	        result = stmt.executeQuery();
	    } catch (SQLException e) {
	        // Add proper error handling here
	    } finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            // Add proper error handling here
	        }
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
	public static ResultSet selectAllDate(String tableName,String startDate,String endDate) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            conn = JDBCON.getConnection();
            String sql = "SELECT * FROM " + tableName
            		+" WHERE date_stored BETWEEN '"+startDate+ "' AND '"+endDate+"'";
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	public static ResultSet selectAllDateCondition(String tableName,String startDate,String endDate,String condition,String keyCondition) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            conn = JDBCON.getConnection();
            String sql = "SELECT * FROM " + tableName
            		+" WHERE date_stored BETWEEN '"+startDate+ "' AND '"+endDate+"'" + " "
            				+ "AND "+keyCondition + " = '" + condition+"'";
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	public static ResultSet selectJoin(String tableName,String table2,String keyCondition) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            conn = JDBCON.getConnection();
            String sql = "SELECT "+tableName+".* FROM " + tableName
            		+ " JOIN "+table2+" ON "+table2+"."+keyCondition + " = " + tableName+"."+keyCondition;
            
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

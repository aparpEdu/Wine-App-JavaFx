package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Storage.Storage;
import Users.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import properties.StorageAccessProperties;
import properties.StorageProperties;
import sqlconnection.helpers.SQLHelper;

public class StorageAccessController {
	private static final String TABLE_NAME = "userss.\"storageaccess\"";
	private static final String TABLE_NAME2 = "userss.\"storage\"";
	private static final String TABLE_NAME3 = "userss.\"Users\"";
	private static final String TABLE_NAME4 = "userss.\"bottle\"";
	private static final String TABLE_NAME5 = "userss.\"grape\"";
	private static final String TABLE_NAME6 = "userss.\"wine\"";
	private static final String TABLE_NAME7 = "userss.\"bottled_wine\"";
	private static final String TABLE_NAME8 = "userss.\"storaged_goods\"";
	private static final String CONDITION_NAME = "storage_name";
	private static final String CONDITION_NAME2 = "username";
	private static final String columnName ="storage_id";
	private static final String columnName2 ="user_id";
	public StorageAccessController() {
		
	}
	public void grantAccess(String username,String storageName) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(columnName);
		data.add(columnName2);
		data.add(TABLE_NAME2);
		data.add(TABLE_NAME3);
		data.add(TABLE_NAME);
		data.add(CONDITION_NAME);
		data.add(CONDITION_NAME2);
		data.add(storageName);
		data.add(username);
		
		SQLHelper.insertConditionData(data);
		
	}
	public void viewAll(ComboBox<String> cb) throws SQLException {
		ResultSet result = SQLHelper.selectAllFromTable(TABLE_NAME2);
	    if(result==null) return;
	   
	    ObservableList<String> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String storageName = result.getString(CONDITION_NAME);
	        
	        data.add(storageName);
	    }
	    cb.setItems(data);
	}
	public void checkAccess(TableView<StorageAccessProperties> table,String choice,String condition) throws SQLException {
		String[] joinTables = {TABLE_NAME, TABLE_NAME2};
		String[] joinConditions = {"user_id", "storage_id"};
		String[] tableNames = {TABLE_NAME3,TABLE_NAME};
		String[] tableNames3 = {TABLE_NAME2,TABLE_NAME3};
		
		if(choice.compareToIgnoreCase(CONDITION_NAME) == 0) {
		ResultSet result = SQLHelper.selectWithJoin(TABLE_NAME3,condition,CONDITION_NAME,joinTables,joinConditions,"else",tableNames,CONDITION_NAME,CONDITION_NAME2,tableNames3,TABLE_NAME2);
		
	    if(result==null) return;
	   
	    ObservableList<StorageAccessProperties> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String storageName = result.getString(CONDITION_NAME);
	        String username = result.getString(CONDITION_NAME2);
	        StorageAccessProperties sap = new StorageAccessProperties();
	        sap.setStorage_name(storageName);
	        sap.setUsername(username);
	        data.add(sap);
	    }
	    table.setItems(data);
		}
		else if (choice.compareToIgnoreCase("yes") == 0) {
			ResultSet result = SQLHelper.selectWithJoin(condition,TABLE_NAME3,TABLE_NAME2,TABLE_NAME);
			
		    if(result==null) return;
		   
		    ObservableList<StorageAccessProperties> data = FXCollections.observableArrayList();
		    while (result.next()) {
		    	String storageName = result.getString(CONDITION_NAME);
			    String username = result.getString(CONDITION_NAME2);
		        StorageAccessProperties sap = new StorageAccessProperties();
		        sap.setStorage_name(storageName);
		        sap.setUsername(username);
		        data.add(sap);
		    }
		    table.setItems(data);
		}
		
	    
	}
//	public void checkUserStorage() throws SQLException {
//		String[] joinConditions = {"storage_id","storage_id","bottle_id","grape_id","wine_id","bottled_wineid"};
//		String[] tableNames = {TABLE_NAME,TABLE_NAME2,TABLE_NAME8,TABLE_NAME8,TABLE_NAME8,TABLE_NAME8};
//		String[] tableNames3 = {TABLE_NAME2,TABLE_NAME8,TABLE_NAME4,TABLE_NAME5,TABLE_NAME6,TABLE_NAME7};
//		//String[] tableNames4 = {TABLE_NAME2,TABLE_NAME4,TABLE_NAME5,TABLE_NAME6,TABLE_NAME7};
//		int condition = Account.getInstance().getId();
//		ResultSet result = SQLHelper.selectWithJoin(TABLE_NAME,condition,columnName2,joinConditions,tableNames,tableNames3);
//		
//	    if(result==null) return;
//	   
//	    ObservableList<String> data = FXCollections.observableArrayList();
//	    while (result.next()) {
//	    	if (result.isBeforeFirst()) {
//	    		  System.out.println("No data found in the result set");
//	    		} else {
//	    		  while (result.next()) {
//	    		    String storageName = result.getString("storage_id");
//	    		    data.add(storageName);
//	    		  }
//	    		 System.out.println(data);
//	    		}
//	    }
//	   
//	}
	public void checkUserStorage() throws SQLException {
	    String[] joinConditions = {"storage_id","storage_id","bottle_id","grape_id","wine_id","bottled_wineid"};
	    String[] tableNames = {TABLE_NAME,TABLE_NAME2,TABLE_NAME8,TABLE_NAME8,TABLE_NAME8,TABLE_NAME8};
	    String[] tableNames3 = {TABLE_NAME2,TABLE_NAME8,TABLE_NAME4,TABLE_NAME5,TABLE_NAME6,TABLE_NAME7};
	    int condition = Account.getInstance().getId();
	    ResultSet result = SQLHelper.selectWithJoin(TABLE_NAME,condition,columnName2,joinConditions,tableNames,tableNames3);

	    if(result==null) return;
	   
	    ObservableList<Integer> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        //String storageName = result.getString("storage_id");
	    	int id = result.getInt("grape_kg");
	        data.add(id);
	    	
	    }
	    
	    if (data.isEmpty()) {
	        System.out.println("No data found in the result set");
	    } else {
	        System.out.println(data);
	    }
	}
	
	
	
	
	

}

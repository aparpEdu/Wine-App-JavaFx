package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	
	
	

}

package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
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
	        String storageName = result.getString("storage_name");
	        
	        data.add(storageName);
	    }
	    cb.setItems(data);
	}

}

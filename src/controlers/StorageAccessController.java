package controlers;

import java.util.HashMap;
import java.util.Map;

import enums.Roles;
import sqlconnection.helpers.SQLHelper;

public class StorageAccessController {
	private static final String TABLE_NAME = "userss.\"storageaccess\"";
	public StorageAccessController() {
		
	}
	public void grantAccess(String username,String storageName) {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("username", username);
		data.put("storage_name", storageName);
		SQLHelper.insertData(TABLE_NAME, data);
		
	}

}

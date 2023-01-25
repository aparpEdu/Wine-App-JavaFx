package controlers;

import java.util.HashMap;
import java.util.Map;

import Users.Account;
import enums.Roles;
import sqlconnection.helpers.SQLHelper;

public class AccountController {
private static final String TABLE_NAME = "userss.\"Users\"";
private static final String conditionName = "username";

	public AccountController() {
		// TODO Auto-generated constructor stub
	}
	public void insert(String username,String pass,Roles role) {
		Map<String,Object> data = new HashMap();
		data.put("username", username);
		data.put("pass", pass);
		data.put("roles", role.name());
		SQLHelper.insertData(TABLE_NAME, data);
		
	}
	public void editUser(String condition,String username,String pass,Roles role) {
		Map<String,Object> data = new HashMap();
		data.put("username", username);
		data.put("pass", pass);
		data.put("roles", role.name());
		SQLHelper.update(TABLE_NAME, data,condition);
		
	}
	public void removeUser(String condition) {
		
		SQLHelper.delete(TABLE_NAME,condition,conditionName);
		
	}

}

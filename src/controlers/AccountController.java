package controlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Users.Account;
import application.helpers.Tables;
import enums.Roles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import properties.UserProperties;
import sqlconnection.JDBCON;
import sqlconnection.helpers.SQLHelper;

public class AccountController {
private static final String TABLE_NAME = "userss.\"Users\"";
private static final String conditionName = "username";
private static final String roleConditionName = "roles";
	public AccountController() {
		// TODO Auto-generated constructor stub
	}
	public void insert(String username,String pass,Roles role) {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("username", username);
		data.put("pass", pass);
		data.put("roles", role.name());
		SQLHelper.insertData(TABLE_NAME, data);
		
	}
	public void editUser(String condition,String username,String pass,Roles role) {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("username", username);
		data.put("pass", pass);
		data.put("roles", role.name());
		SQLHelper.update(TABLE_NAME, data,condition,conditionName);
		
	}
	public void removeUser(String condition) {
		
		SQLHelper.delete(TABLE_NAME,condition,conditionName);
		
	}
	public void selectUser(TableView<UserProperties> table,String condition,String choice) throws SQLException {
		
		if(choice.compareToIgnoreCase("byRole") == 0) {
			
		
		ResultSet result = SQLHelper.select(TABLE_NAME, condition, roleConditionName);
	    if(result==null) return;
	   
	    ObservableList<UserProperties> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String username = result.getString("username");
	        String pass = result.getString("pass");
	        String role = result.getString("roles");
	        UserProperties acc = new UserProperties();
	        acc.setUsername(username);
	        acc.setPassword(pass);
	        acc.setRole(role);
	        data.add(acc);
	    }
	    table.setItems(data);
		}
		else if(choice.compareToIgnoreCase("byName") == 0) {
			ResultSet result = SQLHelper.select(TABLE_NAME, condition, conditionName);
		    if(result==null) return;
		   
		    ObservableList<UserProperties> data = FXCollections.observableArrayList();
		    while (result.next()) {
		        String username = result.getString("username");
		        String pass = result.getString("pass");
		        String role = result.getString("roles");
		        UserProperties acc = new UserProperties();
		        acc.setUsername(username);
		        acc.setPassword(pass);
		        acc.setRole(role);
		        data.add(acc);
		    }
		    table.setItems(data);
		}
	    
	}
		


public void showAllUsers(TableView<UserProperties> table) throws SQLException {
    ResultSet result = SQLHelper.selectAllFromTable(TABLE_NAME);
    if(result==null) return;
   
    ObservableList<UserProperties> data = FXCollections.observableArrayList();
    while (result.next()) {
        String username = result.getString("username");
        String pass = result.getString("pass");
        String role = result.getString("roles");
        UserProperties acc = new UserProperties();
        acc.setUsername(username);
        acc.setPassword(pass);
        acc.setRole(role);
        data.add(acc);
    }
    table.setItems(data);
}

}

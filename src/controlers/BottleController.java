package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import properties.BottleProperties;
import properties.UserProperties;
import sqlconnection.helpers.SQLHelper;

public class BottleController {
	final static String TABLE_NAME = "userss.\"bottle\"";
	final static String TABLE_NAME2 = "userss.\"storaged_goods\"";
	final static String KEY_CONDITION = "bottle_size";
	public BottleController() {
		// TODO Auto-generated constructor stub
	}

	public void storeBottles(String size,int quantity) throws SQLException {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("bottle_size", size);
		data.put("bottle_quantity", quantity);
		SQLHelper.insertData(TABLE_NAME, data);
		
		
	}

	public void searchBottles(TableView<BottleProperties> table,String startDate,String endDate) throws SQLException {
		
		
		ResultSet result = SQLHelper.selectAllDate("storaged_goods_with_dates",startDate,endDate);
		    if(result==null) return;
		   
		    ObservableList<BottleProperties> data = FXCollections.observableArrayList();
		    while (result.next()) {
		        String size = result.getString("bottle_size");
		        int quantity = result.getInt("bottle_quantity");
		        String date = result.getString("date_stored");
		        BottleProperties bp = new BottleProperties();
		        bp.setBottle_size(size);
		        bp.setQuantity(String.valueOf(quantity));
		        bp.setDate(date);
		        data.add(bp);
		    }
		    table.setItems(data);
		   
		
		
		
	}
	public void searchSpecific(TableView<BottleProperties> table,String startDate,String endDate,String condition) throws SQLException {
		System.out.println("dd");
		ResultSet result = SQLHelper.selectAllDateCondition("storaged_goods_with_dates",startDate,endDate, condition,KEY_CONDITION);
	    if(result==null) return;
	   
	    ObservableList<BottleProperties> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String size = result.getString("bottle_size");
	        int quantity = result.getInt("bottle_quantity");
	        String date = result.getString("date_stored");
	        BottleProperties bp = new BottleProperties();
	        bp.setBottle_size(size);
	        bp.setQuantity(String.valueOf(quantity));
	        bp.setDate(date);
	        data.add(bp);
	    }
	    table.setItems(data);
	}
	
}

package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import properties.WineProperty;
import sqlconnection.helpers.SQLHelper;

public class WineController {
	final static String TABLE_NAME = "userss.\"wine\"";
	final static String KEY_CONDITION = "wine_variety";
	final static String KEY_CONDITION2 = "grape_color";
	final static String KEY_CONDITION3 = "bottle_size";
public void searchWine(TableView<WineProperty> table,String startDate,String endDate) throws SQLException {
		
		
		ResultSet result = SQLHelper.selectAllDate("wine_storage_details",startDate,endDate);
		    if(result==null) return;
		   
		    ObservableList<WineProperty> data = FXCollections.observableArrayList();
		    while (result.next()) {
		        String variety = result.getString("wine_variety");
		        float filled = result.getFloat("filled_amount");
		        String date = result.getString("date_stored");
		        String color = result.getString("grape_color");
		        float quantity = result.getFloat("wine_quantity");	      
		        String size = result.getString("bottle_size");
		        WineProperty wp = new WineProperty();
		        wp.setVariety(variety);
		        wp.setFilled(String.valueOf(filled));
		        wp.setDate(date);
		        wp.setColor(color);
		        wp.setQuantity(String.valueOf(quantity));
		        wp.setSize(size);
		        data.add(wp);
		    }
		    
		    table.setItems(data);
		   
		
		
		
	}
public void searchByVariety(TableView<WineProperty> table,String startDate,String endDate,String condition) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllDateCondition("wine_storage_details",startDate,endDate,condition,KEY_CONDITION);
	    if(result==null) return;
	   
	    ObservableList<WineProperty> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("wine_variety");
	        float filled = result.getFloat("filled_amount");
	        String date = result.getString("date_stored");
	        String color = result.getString("grape_color");
	        float quantity = result.getFloat("wine_quantity");	      
	        String size = result.getString("bottle_size");
	        WineProperty wp = new WineProperty();
	        wp.setVariety(variety);
	        wp.setFilled(String.valueOf(filled));
	        wp.setDate(date);
	        wp.setColor(color);
	        wp.setQuantity(String.valueOf(quantity));
	        wp.setSize(size);
	        data.add(wp);
	    }
	    
	    table.setItems(data);
	   
	
	
	
}
public void searchByColor(TableView<WineProperty> table,String startDate,String endDate,String condition) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllDateCondition("wine_storage_details",startDate,endDate,condition,KEY_CONDITION2);
	    if(result==null) return;
	   
	    ObservableList<WineProperty> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("wine_variety");
	        float filled = result.getFloat("filled_amount");
	        String date = result.getString("date_stored");
	        String color = result.getString("grape_color");
	        float quantity = result.getFloat("wine_quantity");	      
	        String size = result.getString("bottle_size");
	        WineProperty wp = new WineProperty();
	        wp.setVariety(variety);
	        wp.setFilled(String.valueOf(filled));
	        wp.setDate(date);
	        wp.setColor(color);
	        wp.setQuantity(String.valueOf(quantity));
	        wp.setSize(size);
	        data.add(wp);
	    }
	    
	    table.setItems(data);
	   
	
	
	
}
public void searchBySize(TableView<WineProperty> table,String startDate,String endDate,String condition) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllDateCondition("wine_storage_details",startDate,endDate,condition,KEY_CONDITION3);
	    if(result==null) return;
	   
	    ObservableList<WineProperty> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("wine_variety");
	        float filled = result.getFloat("filled_amount");
	        String date = result.getString("date_stored");
	        String color = result.getString("grape_color");
	        float quantity = result.getFloat("wine_quantity");	      
	        String size = result.getString("bottle_size");
	        WineProperty wp = new WineProperty();
	        wp.setVariety(variety);
	        wp.setFilled(String.valueOf(filled));
	        wp.setDate(date);
	        wp.setColor(color);
	        wp.setQuantity(String.valueOf(quantity));
	        wp.setSize(size);
	        data.add(wp);
	    }
	    
	    table.setItems(data);
	   
	
	
	
}

}

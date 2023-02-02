package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import properties.WineProperty;
import sqlconnection.helpers.SQLHelper;

public class WineController {
	final static String TABLE_NAME = "userss.\"wine\"";
	final static String TABLE1="userss.\"grape\"";
	final static String TABLE2="userss.\"bottle\"";
	final static String TABLE3="userss.\"storaged_goods\"";
	final static String KEY_CONDITION = "wine_variety";
	final static String KEY_CONDITION2 = "grape_color";
	final static String KEY_CONDITION3 = "bottle_size";
	final static String KEY_CONDITION4 = "bottle_id";
	final static String KEY_CONDITION5 = "grape_kg";
	final static String KEY_CONDITION6 = "grape_id";
	final static String KEY_CONDITION7 = "wineperkg";
	final static String KEY_CONDITION8 = "grape_variety";
public void searchWine(TableView<WineProperty> table,String startDate,String endDate) throws SQLException {
		
		
		ResultSet result = SQLHelper.selectAllDate("wine_storage_details",startDate,endDate);
		    if(result==null) return;
		   
		    ObservableList<WineProperty> data = FXCollections.observableArrayList();
		    while (result.next()) {
		        String variety = result.getString("wine_variety");
		        float filled = result.getFloat("filled_amount");
		        String date = result.getString("date_stored");
		        float quantity = result.getFloat("wine_quantity");	      
		        String size = result.getString("bottle_size");
		        WineProperty wp = new WineProperty();
		        wp.setVariety(variety);
		        wp.setFilled(String.valueOf(filled));
		        wp.setDate(date);
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
	        float quantity = result.getFloat("wine_quantity");	      
	        String size = result.getString("bottle_size");
	        WineProperty wp = new WineProperty();
	        wp.setVariety(variety);
	        wp.setFilled(String.valueOf(filled));
	        wp.setDate(date);
	        wp.setQuantity(String.valueOf(quantity));
	        wp.setSize(size);
	        data.add(wp);
	    }
	    
	    table.setItems(data);
	   
	
	
	
}
public void viewVars(ComboBox<String> cb) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllFromTable("wine_storage_details");
	    if(result==null) return;
	   
	    ObservableList<String> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("wine_variety");
	        
	   
	        data.add(variety);
	    }
	    
	    cb.setItems(data);
	   
	
	
	
}

public void searchBySize(TableView<WineProperty> table,String startDate,String endDate,String condition) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllDateCondition("wine_storage_details",startDate,endDate,condition,KEY_CONDITION3);
	    if(result==null) return;
	   
	    ObservableList<WineProperty> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("wine_variety");
	        float filled = result.getFloat("filled_amount");
	        String date = result.getString("date_stored");
	        float quantity = result.getFloat("wine_quantity");	      
	        String size = result.getString("bottle_size");
	        WineProperty wp = new WineProperty();
	        wp.setVariety(variety);
	        wp.setFilled(String.valueOf(filled));
	        wp.setDate(date);
	        wp.setQuantity(String.valueOf(quantity));
	        wp.setSize(size);
	        data.add(wp);
	    }
	    
	    table.setItems(data);
	   
	
	
	
}

public void CreateWine(String wkg1,String wkg2,String kg1,String kg2,String size,String kgneeded1,String kgneeded2,String filled,String var,String grvar,String grvar2)
{
	
	float quantity=0;
	String[] arr1= {KEY_CONDITION6,KEY_CONDITION7,KEY_CONDITION5,KEY_CONDITION8};

		
//	   float winekg1=Float.parseFloat(wkg1);
//	   float winekg2=Float.parseFloat(wkg2);
//	   float kg=Float.parseFloat(kgneeded1);
	   String[] arr= {wkg1,kg1,grvar};
	   String[] arr2= {wkg2,kg2,grvar2};
	   Float newkg1=Float.parseFloat(kg1)-Float.parseFloat(kgneeded1);
	   Float newkg2=Float.parseFloat(kg2)-Float.parseFloat(kgneeded2);
	  
	   quantity+=Float.parseFloat(kgneeded1)*Float.parseFloat(wkg1);
	   quantity+=Float.parseFloat(kgneeded2)*Float.parseFloat(wkg2);
	   SQLHelper.updateSelect(TABLE3, arr, KEY_CONDITION5,String.valueOf(newkg1),arr1,TABLE1 );
	   SQLHelper.updateSelect(TABLE3, arr2, KEY_CONDITION5,String.valueOf(newkg2),arr1,TABLE1 );
	   
	
	
	Map<String,Object> data = new HashMap<String, Object>();
	
	
	data.put("wine_quantity", quantity);
	data.put("bottle_size",size );
	data.put("filled_amount", Float.parseFloat(filled));
	data.put("wine_variety", var);
	data.put("grapekg_needed", Float.parseFloat(kgneeded1));
	data.put("grapekg_needed2", Float.parseFloat(kgneeded2));
	
	
	SQLHelper.deleteSelect(TABLE3,size, KEY_CONDITION3,TABLE2,KEY_CONDITION4);

	SQLHelper.insertData(TABLE_NAME, data);
	

}
}

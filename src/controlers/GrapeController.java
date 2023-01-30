package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import enums.Color;
import enums.Variety;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import properties.BottleProperties;
import properties.GrapeProperties;
import properties.UserProperties;
import sqlconnection.helpers.SQLHelper;

public class GrapeController {
final static String TABLE_NAME = "userss.\"grape\"";
final static String KEY_CONDITION = "grape_variety";
final static String KEY_CONDITION2 = "grape_color";
	
	public void storeGrapes(Variety variety,double kg) throws SQLException {
		Map<String,Object> data = new HashMap<String, Object>();
		
		data.put("grape_variety", variety.name());
		//data.put("date_stored", dateData);
		data.put("grape_kg", kg);
		if (variety == Variety.Cabernet || variety == Variety.Merlot || variety == Variety.Barbera
				|| variety == Variety.Molinara || variety == Variety.Tannat || variety == Variety.Tannat
				|| variety == Variety.Sangiovese || variety == Variety.Marselan || variety == Variety.Pinotage
				|| variety == Variety.Cinsaut) {
			data.put("grape_color", Color.RED.toString());
		}
		else {
			data.put("grape_color", Color.WHITE.toString());
		}

		SQLHelper.insertData(TABLE_NAME, data);
	}
public void searchGrapes(TableView<GrapeProperties> table,String startDate,String endDate) throws SQLException {
		
		
		ResultSet result = SQLHelper.selectAllDate("storaged_goods_with_grapes",startDate,endDate);
		    if(result==null) return;
		   
		    ObservableList<GrapeProperties> data = FXCollections.observableArrayList();
		    while (result.next()) {
		        String variety = result.getString("grape_variety");
		        float kg = result.getFloat("grape_kg");
		        String date = result.getString("date_stored");
		        String color = result.getString("grape_color");
		        float wkg = result.getFloat("wineperkg");
		        
		        GrapeProperties gp = new GrapeProperties();
		        gp.setColor(color);
		        gp.setKg(String.valueOf(kg));
		        gp.setVariety(variety);
		        gp.setWkg(String.valueOf(wkg));
		        gp.setDate(date);
		        data.add(gp);
		    }
		    table.setItems(data);
		   
		
		
		
	}
public void showGrapesForEvaluation(TableView<GrapeProperties> table) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllFromTable("storaged_goods_with_grapes");
	    if(result==null) return;
	   
	    ObservableList<GrapeProperties> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("grape_variety");
	        float kg = result.getFloat("grape_kg");
	        String date = result.getString("date_stored");
	        String color = result.getString("grape_color");
	        float wkg = result.getFloat("wineperkg");
	   
	      
	        GrapeProperties gp = new GrapeProperties();
	        gp.setColor(color);
	        gp.setKg(String.valueOf(kg));
	        gp.setVariety(variety);
	        gp.setWkg(String.valueOf(wkg));
	        gp.setDate(date);
	        data.add(gp);
	    }
	    table.setItems(data);
	   
	
	
	
}
public void searchByVariety(TableView<GrapeProperties> table,String startDate,String endDate,String condition) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllDateCondition("storaged_goods_with_grapes",startDate,endDate,condition,KEY_CONDITION);
	    if(result==null) return;
	   
	    ObservableList<GrapeProperties> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("grape_variety");
	        float kg = result.getFloat("grape_kg");
	        String date = result.getString("date_stored");
	        String color = result.getString("grape_color");
	        float wkg = result.getFloat("wineperkg");
	        GrapeProperties gp = new GrapeProperties();
	        gp.setColor(color);
	        gp.setKg(String.valueOf(kg));
	        gp.setVariety(variety);
	        gp.setWkg(String.valueOf(wkg));
	        gp.setDate(date);
	        data.add(gp);
	    }
	    table.setItems(data);
	   
	
	
	
}
public void searchByColor(TableView<GrapeProperties> table,String startDate,String endDate,String condition) throws SQLException {
	
	
	ResultSet result = SQLHelper.selectAllDateCondition("storaged_goods_with_grapes",startDate,endDate,condition,KEY_CONDITION2);
	    if(result==null) return;
	   
	    ObservableList<GrapeProperties> data = FXCollections.observableArrayList();
	    while (result.next()) {
	        String variety = result.getString("grape_variety");
	        float kg = result.getFloat("grape_kg");
	        String date = result.getString("date_stored");
	        String color = result.getString("grape_color");
	        float wkg = result.getFloat("wineperkg");
	        GrapeProperties gp = new GrapeProperties();
	        gp.setColor(color);
	        gp.setKg(String.valueOf(kg));
	        gp.setVariety(variety);
	        gp.setWkg(String.valueOf(wkg));
	        gp.setDate(date);
	        data.add(gp);
	    }
	    table.setItems(data);
	   
	
	
	
}
}

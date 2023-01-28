package controlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import enums.Color;
import enums.Variety;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import properties.UserProperties;
import sqlconnection.helpers.SQLHelper;

public class GrapeController {
final static String TABLE_NAME = "userss.\"grape\"";
	
	public void storeGrapes(Variety variety,double kg) throws SQLException {
		 ObservableList<String> dateData = FXCollections.observableArrayList();
		ResultSet result = SQLHelper.getCurrentDate();
	    if(result==null) return;
	    while (result.next()) {
	        String date = result.getString("CURRENT_DATE");
	        dateData.add(date);
	    }
		Map<String,Object> data = new HashMap<String, Object>();
		
		data.put("grape_variety", variety.name());
		data.put("date_stored", dateData);
		data.put("grape_kg", kg);
		if (variety == Variety.Cabernet || variety == Variety.Merlot || variety == Variety.Barbera
				|| variety == Variety.Molinara || variety == Variety.Tannat || variety == Variety.Tannat
				|| variety == Variety.Sangiovese || variety == Variety.Marselan || variety == Variety.Pinotage
				|| variety == Variety.Cinsaut) {
			data.put("grape_color", Color.RED);
		}
		else {
			data.put("grape_color", Color.WHITE);
		}
//		data.put("pass", pass);
//		data.put("roles", role.name());
		SQLHelper.insertData(TABLE_NAME, data);
	}
}

package Storage;

import java.sql.SQLException;

import controlers.BottleController;
import controlers.GrapeController;

public class StorageFiller {
//private final static String grapeTable="";
	public StorageFiller() {
		// TODO Auto-generated constructor stub
	}
	public  static void  fillGrape() throws SQLException
	{
		 GrapeController g=new GrapeController();
		Storage.getInstance().setGrapes(g.getAll());
		
	}
	public  static void  fillBottle() throws SQLException
	{
		 BottleController g=new BottleController();
		Storage.getInstance().setBottles(g.getAllBottle());
		
	}

}

package sqlconnection.helpers;

import java.sql.SQLException;

import Storage.StorageFiller;

public class ResourceLoader {

	public ResourceLoader() {
		// TODO Auto-generated constructor stub
	}
	public static void loadResources() throws SQLException
	{
		
		StorageFiller.fillGrape();
		StorageFiller.fillBottle();
	}

}

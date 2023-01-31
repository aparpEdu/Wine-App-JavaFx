package sqlconnection.helpers;

import java.sql.Types;

public class sqlConverter {

	public sqlConverter() {
		// TODO Auto-generated constructor stub
	}
	public static int doubleParser(Object object) {
		
		try{
			
			@SuppressWarnings("unused")
			Float d = Float.parseFloat(object.toString());
			
			return Types.NUMERIC;
		}
		catch(Exception e) {
			return Types.VARCHAR;
		}
		
	}
public static double floatParse(Object object) {
		
		try{
						Float d =Float.parseFloat(object.toString());
			
			return d;
		}
		catch(Exception e) {
			return 5.5;
		}
		
	}

}
//if(sqlConverter.doubleParser(entry.getValue()) == Types.VARCHAR) {
//    stmt.setObject(i, entry.getValue(),Types.VARCHAR);
//	}
//	else {
//		stmt.setObject(i, sqlConverter.doubleParse(entry.getValue()),Types.NUMERIC);
//	}
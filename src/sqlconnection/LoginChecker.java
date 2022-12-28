package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Users.Account;


public class LoginChecker {
	private static final String dbDriver="org.postgresql.Driver";
	private static final String dbUrl="jdbc:postgresql://localhost:5432/postgres";
	private static  String dbUsername="postgres";
	private static String dbPassword="dancho39";
	//private String masterUser="dancho39";
	//private String masterPass="maximus1";
	public LoginChecker()
	{
		
	}
	public boolean check(String username,String password)
	{
		Connection con=null;
		try {
			Class.forName(dbDriver);
			
			 con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			Statement st = con.createStatement();
			
			
			String sql="SELECT * FROM userss.\"Users\" ;";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("username").equals(username)&&rs.getString("pass").equals(password))
				{
					Account.getInstance().setUsername(username);
					Account.getInstance().setPassword(password);
					Account.getInstance().setRole(rs.getString("roles"));
					con.close();
					return true;
				}
			}
			con.close();
			return false;
			}
		catch(Exception e)
			{
			System.out.println(e);
			return false;
			}

	}

}

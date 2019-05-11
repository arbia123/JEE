package Com.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class DBConnection {
	
	/*public static Connection createConnection()
	{
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/customers";
	String username = "root";
	String password = "";
	try
	
	{
		
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	}
	catch (ClassNotFoundException e)
	{
		throw new SQLException(e);
	}

	con = DriverManager.getConnection(url, username, password);

	System.out.println("Post establishing a DB connection - "+con);
	
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	 
	return con;
	}
	public void methode(Object objet) 
	{
	 if (objet == null) {
	 throw new IllegalArgumentException("La variable Objet ne doit pas être null");
	 }
	}
	*/
	private static Connection connection;
	
	static {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static Connection getConnection() {
		return connection;
	}

	
	
	}


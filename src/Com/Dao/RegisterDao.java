package Com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Com.Bean.Register;
import Com.Util.DBConnection;

public class RegisterDao {
	public String registerUser(Register registerBean)
	{
	String fullName = registerBean.getFullName();
	String tel = registerBean.gettel();
	String userName = registerBean.getUserName();
	String password = registerBean.getPassword();
	String role = registerBean.getRole();

	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
	con = DBConnection.getConnection();
	String query = "insert into users(id,fullName,tel,userName,password,role) values (null,?,?,?,?,?)"; //Insert user details into the table 'USERS'
	preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	preparedStatement.setString(1, fullName);
	preparedStatement.setString(2, tel);
	preparedStatement.setString(3, userName);
	preparedStatement.setString(4, password);
	preparedStatement.setString(5, role);
	int i= preparedStatement.executeUpdate();
	if (i!=0)  //Just to ensure data has been inserted into the database
	return "SUCCESS"; 
	}
	catch(SQLException e)
	{
	e.printStackTrace();
	}
	return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}

}

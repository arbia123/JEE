package Com.Dao;
 
import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import Com.Bean.Register;
 import Com.Util.DBConnection;
 public class LoginDao {
	 
 
 public String authenticateUser(Register login)
 {
 
String userName = login.getUserName(); //Keeping user entered values in temporary variables.
 String password = login.getPassword();
 
Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
String userNameDB = "";
 String passwordDB = "";
 String roleDB = "";
 
try
 {
 con = DBConnection.getConnection(); //establishing connection
 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
 resultSet = statement.executeQuery("select userName,password,role from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
 
while(resultSet.next()) // Until next row is present otherwise it return false
 {
  userNameDB = resultSet.getString("userName"); //fetch the values present in database
  passwordDB = resultSet.getString("password");
  roleDB = resultSet.getString("role");
  
 
   if(userName.equals(userNameDB) && password.equals(passwordDB)&&roleDB.equals("Conducteur"))
   {
      return "Conducteur_Role"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
   }
   else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("user"))
	   return "User_Role";  
 }
 
 }catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials"; // Just returning appropriate message otherwise
 }
 
 }

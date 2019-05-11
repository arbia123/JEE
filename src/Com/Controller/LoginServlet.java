package Com.Controller;
 import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Bean.Register;
import Com.Bean.Trip_voit;
import Com.Dao.LoginDao;
import Com.Dao.TripDao;
 
public class LoginServlet extends HttpServlet {
 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public LoginServlet() {
 }
 

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	this.getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);

}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
String userName = request.getParameter("username");
 String password = request.getParameter("password");
 
Register loginBean = new Register(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
 loginBean.setPassword(password);
 
LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
try
{
String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
 
if(userValidate.equals("Conducteur_Role"))
{
System.out.println("Drive's Home");

HttpSession session = request.getSession(); //Creating a session
session.setAttribute("Conducteur", userName); //setting session attribute
request.setAttribute("userName", userName);

request.getRequestDispatcher("/jsp/Trip.jsp").forward(request, response);
}
else if(userValidate.equals("User_Role"))
{
System.out.println("User's Home");

HttpSession session = request.getSession();
session.setMaxInactiveInterval(10*60);
session.setAttribute("User", userName);
request.setAttribute("username", userName);

request.getRequestDispatcher("/jsp/User.jsp").forward(request, response);
}
else
{
System.out.println("Error message = "+userValidate);
request.setAttribute("errMessage", userValidate);

request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
}
}
catch (IOException e1)
{
e1.printStackTrace();
}
}
}
  
 

 

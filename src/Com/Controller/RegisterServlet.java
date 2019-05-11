package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Bean.Register;
import Com.Dao.RegisterDao;


/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fullName = request.getParameter("fullname");
		 String tel = request.getParameter("tel");
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 String role = request.getParameter("role");
		 
		 Register registerBean = new Register();
		 //Using Java Beans - An easiest way to play with group of related data
		 registerBean.setFullName(fullName);
		 registerBean.settel(tel);
		 registerBean.setUserName(userName);
		 registerBean.setPassword(password); 
		 registerBean.setRole(role);
		 
		 RegisterDao registerDao = new RegisterDao();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = registerDao.registerUser(registerBean);
		 
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("jsp/Register.jsp").forward(request, response);
		 }
		 }
	

}

package Com.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Bean.Trip_voit;
import Com.Bean.Tripmodel;
import Com.Dao.TripDao;

/**
 * Servlet implementation class ListeServlet
 */

public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

		TripDao dao= new TripDao();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Trip_voit trip = new Trip_voit();
		doPost(request,response);
	        
	        }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tripmodel t = new Tripmodel();
		request.setAttribute("model", t);
		String action= request.getParameter("action");
		if (action!=null) {
			if(action.equals("chercher")) {
				
				t.setMotcle(request.getParameter("motcle"));
				List<Trip_voit> trips = (List<Trip_voit>) dao.TripParLieu(t.getMotcle());
				t.setTrips(trips); 
				  
			}
			else if(action.equals("delete")) {
				int id=Integer.parseInt(request.getParameter("id"));
				dao.deleteTrip( id);
				t.setTrips(dao.getAllTrips());
			}
			else if(action.equals("lister")) {
				
				List<Trip_voit> trips = (List<Trip_voit>) dao.getAllTrips();
				t.setTrips(trips); 
			}
		}
			
	
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/Chercher.jsp");
        requestDispatcher.forward(request, response);
		

	}

}

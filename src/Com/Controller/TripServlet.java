package Com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Com.Bean.Trip_voit;
import Com.Bean.Tripmodel;
import Com.Dao.TripDao;

/**
 * Servlet implementation class TripServlet
 */

public class TripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripDao dao= new TripDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Tripmodel t = new Tripmodel();
		request.setAttribute("model", t);
		String action= request.getParameter("action");
		if (action!=null) {
			if(action.equals("liste")) {
				
				
				List<Trip_voit> trips = (List<Trip_voit>) dao.getAllTrips();
				t.setTrips(trips); 
				  
			}
			else if(action.equals("delete")) {
				int id=Integer.parseInt(request.getParameter("id"));
				dao.deleteTrip( id);
				t.setTrips(dao.getAllTrips());
			}
			else if(action.equals("edit")) {
				int id=Integer.parseInt(request.getParameter("id"));
				Trip_voit tr=dao.getTrip(id);
				t.setTrip(tr);
				t.setMode("edit");
				t.setTrips(dao.getAllTrips());
			}
			else if(action.equals("save")) {
				
				t.getTrip().setDatedep(request.getParameter("datedep"));
				t.getTrip().setDatearr( request.getParameter("datearr"));
				t.getTrip().setLieu(request.getParameter("lieu"));
				t.getTrip().setType_voit(request.getParameter("type_voit"));
				t.getTrip().setNbre_place(request.getParameter("nbre_places"));
				t.setMode(request.getParameter("mode"));
				if (t.getMode().equals("ajout")) {
				dao.registerTrip(t.getTrip());}
				else if (t.getMode().equals("edit")) {
                    dao.updateTrip(t.getTrip());
					t.setTrips(dao.getAllTrips()); 
					
				}
				

		}
			
	
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/Trip.jsp");
        requestDispatcher.forward(request, response);
		
		
	}
		
	}}		
		
		
		




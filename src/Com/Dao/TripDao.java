package Com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Statement;

import Com.Bean.Trip_voit;
import Com.Util.DBConnection;

public class TripDao {
static Connection con = null;
	
	PreparedStatement preparedStatement = null;
	public String registerTrip(Trip_voit trip)
	{
	String datedep = trip.getDatedep();
	String datearr = trip.getDatearr();
	String lieu = trip.getLieu();
	String type_voit = trip.getType_voit();
	String nbre_place = trip.getNbre_place();
	
	try
	{
	con = DBConnection.getConnection();
	String query = "insert into trip_voiture(id,datedep,datearr,lieu,type_voit,nbr_place) values (NULL,?,?,?,?,?)"; //Insert user details into the table 'USERS'
	preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	preparedStatement.setString(1, datedep);
	preparedStatement.setString(2, datearr);
	preparedStatement.setString(3, lieu);
	preparedStatement.setString(4, type_voit);
	preparedStatement.setString(5, nbre_place);
	int i= preparedStatement.executeUpdate();
	if (i!=0)  //Just to ensure data has been inserted into the database
	return "SUCCESS"; 
	}
	catch(SQLException e)
	{
	e.printStackTrace();
}
	return "Oops.. Something went wrong there..!";
	
	
}
	

	
	 public void deleteTrip(int id) {
	         try {
	        	con = DBConnection.getConnection();
	        	String query =("delete trip_voiture where id=?");
	            PreparedStatement preparedStatement = con.prepareStatement( query );
	           
	            preparedStatement.setInt(1,id); 
	      
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        	
	        	}


	         catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public  void updateTrip(Trip_voit trip) {
	        try {
	        	con = DBConnection.getConnection();
	        	String query =("update trip_voiture set datedep=?, datearr=?, lieu=?, type_voit=?, nbr_place=?" +"where id=?");
	            PreparedStatement preparedStatement = con.prepareStatement( query );
	            // Parameters start with 1
	            preparedStatement.setString(1, trip.getDatedep());
	            preparedStatement.setString(2, trip.getDatearr());
	            preparedStatement.setString(3, trip.getLieu());
	            preparedStatement.setString(4, trip.getType_voit());
	            preparedStatement.setString(5, trip.getNbre_place());
	            preparedStatement.setInt(6, trip.getIdTrip());
	         
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        	
	        	}
	       
	        	catch(SQLException e)
	        	{
	        	e.printStackTrace();
	        }
	        	
	       
	       
	    }

	    public  List<Trip_voit> getAllTrips()  {
	    	List<Trip_voit> listTrip = new ArrayList<>();
	    	con = DBConnection.getConnection();
	    try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM trip_voiture");

	  
	        ResultSet resultSet = preparedStatement.executeQuery();
	         
	        while (resultSet.next()) {
	        	  Trip_voit trip = new Trip_voit();
	            trip.setIdTrip(resultSet.getInt("id"));
	            trip.setDatedep(resultSet.getString("datedep"));
                trip.setDatearr(resultSet.getString("datearr"));
                trip.setLieu(resultSet.getString("lieu"));
            
                trip.setType_voit(resultSet.getString("type_voit"));
                trip.setNbre_place(resultSet.getString("nbr_place"));
               
	            listTrip.add(trip);
	        }
	        preparedStatement.close();
	    }
	        
	        catch(SQLException e)
        	{
        	e.printStackTrace();}
        	
	        return listTrip;	    
	    }   
	    
	    
	    public  List<Trip_voit> TripParLieu( String lieu) {
	    	List<Trip_voit> listTrip = new ArrayList<>();
	    	con = DBConnection.getConnection();
	    try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM trip_voiture where lieu=?");
            preparedStatement.setString(1, lieu);
	  
	        ResultSet resultSet = preparedStatement.executeQuery();
	         
	        while (resultSet.next()) {
	        	  Trip_voit trip = new Trip_voit();
	            trip.setIdTrip(resultSet.getInt("id"));
	            trip.setDatedep(resultSet.getString("datedep"));
                trip.setDatearr(resultSet.getString("datearr"));
                trip.setLieu(resultSet.getString("lieu"));
            
                trip.setType_voit(resultSet.getString("type_voit"));
                trip.setNbre_place(resultSet.getString("nbr_place"));
               
	            listTrip.add(trip);
	        }
	         
	        preparedStatement.close();
	         
	    }  catch (SQLException e) {
            e.printStackTrace();
        }
	         
	        return listTrip;	    }

	    public  Trip_voit getTrip(int id) {   
	    	  Trip_voit trip = null;
	          con = DBConnection.getConnection();
	          
	          try {
	        	  PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM trip_voiture where id=?");
		            preparedStatement.setInt(1, id);
	              ResultSet rs =preparedStatement .executeQuery();
	             if(rs.next()) 
	              { Trip_voit trip1 = new Trip_voit();
	            	  
	                  trip1.setDatedep(rs.getString("datedep"));
	                  trip1.setDatearr(rs.getString("datearr"));
	                  trip1.setLieu(rs.getString("lieu"));
	                  trip1.setType_voit(rs.getString("type_voit"));
	                  trip1.setNbre_place(rs.getString("nbr_place"));

	              }
	             preparedStatement.close();
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	         if (trip==null)throw new RuntimeException("trip introuvable");
	        return trip;
	    }
	}
	


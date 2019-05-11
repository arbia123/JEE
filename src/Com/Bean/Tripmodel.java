package Com.Bean;

import java.util.ArrayList;
import java.util.List;

public class Tripmodel {
	private Trip_voit trip = new Trip_voit(); 
	private String motcle;
	private String error;
	private String mode="ajout";
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private List<Trip_voit> trips= new ArrayList<Trip_voit>();
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	public Trip_voit getTrip() {
		return trip;
	}
	public void setTrip(Trip_voit trip) {
		this.trip = trip;
	}
	public List<Trip_voit> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip_voit> trips) {
		this.trips = trips;
	}

}

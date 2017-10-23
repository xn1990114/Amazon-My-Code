package design_AirTrafficControlSystem;
import java.util.*;

public class Track {
	int id;
	TreeSet<Flight> assignedFlight;
	public Track(int id) {
		this.assignedFlight=new TreeSet<Flight>();
		this.id = id;
	}
	
	public boolean assignFlight(Flight f){
		Flight low=this.assignedFlight.floor(f);
		Flight high=this.assignedFlight.ceiling(f);
		if(low!=null&&low.scheduledTime+1500>=f.scheduledTime){
			return false;
		}
		if(high!=null&&f.scheduledTime+1500>=high.assignedAirZoneID){
			return false;
		}
		this.assignedFlight.add(f);
		return true;
	}
	
	public boolean removeFlgiht(Flight f){
		if(this.assignedFlight.contains(f)){
			this.assignedFlight.remove(f);
			return true;
		}
		return false;
	}
}

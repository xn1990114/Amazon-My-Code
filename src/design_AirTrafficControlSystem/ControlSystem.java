package design_AirTrafficControlSystem;
import java.util.*;

public class ControlSystem {
	Map<String,Flight> flights;
	List<Track> tracks;
	List<AirZone> airzones;
	
	public ControlSystem() {
		this.flights=new HashMap<String,Flight>();
		this.tracks=new ArrayList<Track>();
		this.airzones=new ArrayList<AirZone>();
	}
	
	public void addNewFlight(String id, int scheduledTime, Direction dir, int assignedTrackID, int assignedAirZoneID){
		Flight f=new Flight(id,scheduledTime,dir);
		this.flights.put(id, f);
		assignFlightToZone(id,assignedAirZoneID);
		assignFlightToTrack(id,assignedTrackID);
	}
	
	public void removeObsoleteFlight(int id){
		Flight f=this.flights.get(id);
		this.flights.remove(id);
		this.tracks.get(f.assignedTrackID).removeFlgiht(f);
		this.airzones.get(f.assignedAirZoneID).removeFlight(f.id);
	}
	
	public void delayFlgiht(int fID,int time){
		Flight f=this.flights.get(fID);
		Track t=this.tracks.get(f.assignedTrackID);
		t.removeFlgiht(f);
		f.scheduledTime=f.scheduledTime+time;
		t.assignFlight(f);
	}

	private void assignFlightToTrack(String id, int assignedTrackID) {
		this.flights.get(id).assignToTrack(assignedTrackID);
		this.tracks.get(assignedTrackID).assignFlight(this.flights.get(id));
	}

	private void assignFlightToZone(String id, int assignedAirZoneID) {
		this.flights.get(id).assignToAirZone(assignedAirZoneID);
		this.airzones.get(assignedAirZoneID).assignFlight(id);
	}
	
}

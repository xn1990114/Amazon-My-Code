package design_AirTrafficControlSystem;

public class Flight implements Comparable<Flight>{
	String id;
	int scheduledTime;
	Direction dir;
	int assignedTrackID;
	int assignedAirZoneID;
	ControlSystem sys;
	
	public Flight(String id, int scheduledTime, Direction dir) {
		this.id = id;
		this.scheduledTime = scheduledTime;
		this.dir = dir;
		this.assignedTrackID = -1;
		this.assignedAirZoneID = -1;
	}
	public void assignToTrack(int trackID){
		this.assignedTrackID=trackID;
	}
	public void assignToAirZone(int zoneID){
		this.assignedAirZoneID=zoneID;
	}
	
	public void landed(){
		//send notice to controlSystem
	}
	public void departed(){
		//send notice to controlSystem
	}

	@Override
	public int compareTo(Flight o) {
		if(this.scheduledTime<o.scheduledTime){
			return -1;
		}
		return 1;
	}
}

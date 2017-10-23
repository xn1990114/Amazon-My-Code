package design_AirTrafficControlSystem;

public class AirZone {
	int id;
	String[] assignedFlights;
	int EmptySpaceCount;
	public AirZone(int id,int maxCapacity){
		this.id=id;
		this.assignedFlights=new String[maxCapacity];
		this.EmptySpaceCount=maxCapacity;
	}
	public boolean assignFlight(String flightID){
		if(this.EmptySpaceCount==0){
			return false;
		}
		for(int i=0;i<this.assignedFlights.length;i++){
			if(this.assignedFlights[i]==null){
				this.assignedFlights[i]=flightID;
				this.EmptySpaceCount--;
				return true;
			}
		}
		return false;
	}
	public boolean removeFlight(String flightID){
		for(int i=0;i<this.assignedFlights.length;i++){
			if(this.assignedFlights[i]==flightID){
				this.assignedFlights[i]=null;
				this.EmptySpaceCount++;
				return true;
			}
		}
		return false;
	}
}

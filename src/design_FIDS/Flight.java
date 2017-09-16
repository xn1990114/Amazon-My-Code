package design_FIDS;

public class Flight implements Comparable<Flight>{
	long ST;
	String airLine;
	String flightID;
	String destination;
	String checkInCounter;
	String gate;
	Direction dir;
	FlightStatus currStatus;
	long ET;
	public Flight(long ST,String airLine,String flightID,String destination,Direction dir){
		this.ST=ST;
		this.airLine=airLine;
		this.flightID=flightID;
		this.destination=destination;
		this.ET=ST;
		this.dir=dir;
	}
	public void updateCounter(String counterID){
		this.checkInCounter=counterID;
	}
	public void updateGate(String gate){
		this.gate=gate;
	}
	public void updateCurrStatus(FlightStatus status){
		this.currStatus=status;
	}
	public void updateET(long ET){
		this.ET=ET;
	}
	@Override
	public int compareTo(Flight f2){
		if(this.ET<f2.ET){
			return -1;
		}
		/*
		else if(this.ET==f2.ET){
			return 0;
		}*/
		return 1;
	}
	@Override
	public String toString() {
		return "Flight [ST=" + ST + ", airLine=" + airLine + ", flightID=" + flightID + ", destination=" + destination
				+ ", checkInCounter=" + checkInCounter + ", gate=" + gate + ", currStatus=" + currStatus + ", ET=" + ET
				+ "]";
	}
	
}

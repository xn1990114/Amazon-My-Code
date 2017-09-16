package design_FIDS;
import java.util.*;

public class FlightManagementSystem {
	DashBoard departureBoard;
	DashBoard arrivalBoard;
	TreeSet<Flight> waitingQueue;
	Map<String,Flight> flightMap;
	long time;
	
	public FlightManagementSystem(){
		this.departureBoard=new DashBoard();
		this.arrivalBoard=new DashBoard();
		this.waitingQueue=new TreeSet<Flight>();
		this.flightMap=new HashMap<String,Flight>();
		this.time=0;
	}
	
	public void addFlight(long ST,String airLine,String flightID,String destination,Direction dir){
		Flight toadd=new Flight(ST,airLine,flightID,destination,dir);
		this.waitingQueue.add(toadd);
		this.flightMap.put(flightID, toadd);
	}
	public void setTime(long time){
		this.time=time;
	}
	
	public void updateDashBoard(){
		Iterator<Flight> it=this.waitingQueue.iterator();
		while(it.hasNext()){
			Flight f=it.next();
			if(f.ET>time+200){
				break;
			}
			if(f.dir==Direction.depart){
				this.departureBoard.addFlgiht(f);
			}
			else{
				this.arrivalBoard.addFlgiht(f);
			}
			it.remove();
		}
		this.departureBoard.removeObsolete(this.time);
		this.arrivalBoard.removeObsolete(this.time);
	}
	public void updateCounter(String flightID,String counterID){
		this.flightMap.get(flightID).updateCounter(counterID);
	}
	public void updateGate(String flightID,String gate){
		this.flightMap.get(flightID).updateGate(gate);
	}
	public void updateCurrStatus(String flightID,FlightStatus status){
		this.flightMap.get(flightID).updateCurrStatus(status);
	}
	public void updateET(String flightID,long ET){
		Flight f=this.flightMap.get(flightID);
		f.updateET(ET);
		if(this.arrivalBoard.flights.contains(f)){
			this.arrivalBoard.updateSeq(f);
		}
		if(this.departureBoard.flights.contains(f)){
			this.departureBoard.updateSeq(f);
		}
	}
	public void display(){
		System.out.println("Departure:");
		this.departureBoard.display();
		System.out.println("Arraival:");
		this.arrivalBoard.display();
	}
}

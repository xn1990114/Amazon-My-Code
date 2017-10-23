package design_MovieBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Play {
	static int nextID=1;
	int id;
	int movieID;
	int roomID;
	int time;
	List<Seat> seats;
	public Play(int id, int movieID, int roomID, int time,int maxCapacity) {
		this.id = id;
		this.movieID = movieID;
		this.roomID = roomID;
		this.time = time;
		this.seats=new ArrayList<Seat>();
		for(int i=1;i<=maxCapacity;i++){
			this.seats.add(new Seat(i,roomID));
		}
	}
	
	
}

package design_MovieBookingSystem;

public class Reservation {
	static int newID=1;
	int id;
	String userName;
	Play play;
	int seatID;
	public Reservation( String userName, Play p, int seatID) {
		super();
		this.id = newID;
		newID++;
		this.userName = userName;
		this.play=p;
		this.seatID = seatID;
	}
	
}

package design_MovieBookingSystem;

public class Seat {
	int id;
	int roomID;
	String assignedTo;
	
	public Seat(int id, int roomID) {
		super();
		this.id = id;
		this.roomID = roomID;
		this.assignedTo=null;
	}
	public void assignToUser(String userName){
		this.assignedTo=userName;
	}
	public void removeUser(){
		this.assignedTo=null;
	}
}

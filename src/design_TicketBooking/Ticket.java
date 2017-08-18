package design_TicketBooking;

public class Ticket {
	public static final String NBA="NBA";
	public static final String NFL="NFL";
	
	public String type;
	public int[] seatNumber;
	public long time;
	
	public Ticket(String type,int r,int c,long time){
		this.type=type;
		int[] seat={r,c};
		this.seatNumber=seat;
		this.time=time;
	}
}

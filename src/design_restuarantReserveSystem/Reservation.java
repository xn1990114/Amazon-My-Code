package design_restuarantReserveSystem;

public class Reservation {
	public int ID;
	public int userID;
	public int restuarantID;
	public int tableID;
	public int startTime;
	public int endTime;
	public Reservation(int ID,int userID,int restuarantID,int tableID,int start,int end){
		this.ID=ID;
		this.userID=userID;
		this.restuarantID=restuarantID;
		this.tableID=tableID;
		this.startTime=start;
		this.endTime=end;
	}
	
}

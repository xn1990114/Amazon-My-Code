package design_restuarantReserveSystem;

import java.util.*;

public class User {
	public int ID;
	Set<Integer> reservations;
	ReservationSystem rs;
	public User(int ID,ReservationSystem rs){
		this.ID=ID;
		this.reservations=new HashSet<Integer>();
		this.rs=rs;
	}
	public boolean reserveTable(int restuarantID,int tableID,int start,int end){
		int rID=this.rs.reserve(this.ID, restuarantID, tableID, start, end);
		if(rID==-1){
			return false;
		}
		this.reservations.add(rID);
		return true;
	}
	public boolean cancelReservation(int reservationID){
		if(!this.reservations.contains(reservationID)){
			return false;
		}
		if(!this.rs.cancel(reservationID)){
			return false;
		}
		this.reservations.remove(reservationID);
		return true;
	}
}

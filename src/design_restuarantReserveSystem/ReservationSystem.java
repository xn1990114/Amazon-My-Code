package design_restuarantReserveSystem;

import java.util.*;

public class ReservationSystem {
	static int reservationID;
	Map<Integer,User> users;
	Map<Integer,Restuarant> restuarants;
	Map<Integer,Reservation> reservations;
	public ReservationSystem(){
		this.users=new HashMap<Integer,User>();
		this.restuarants=new HashMap<Integer,Restuarant>();
		this.reservations=new HashMap<Integer,Reservation>();
	}
	public int reserve(int userID,int restuarantID,int tableID,int start,int end){
		if(!restuarants.get(restuarantID).reserveTable(tableID,start,end)){
			return -1;
		}
		Reservation r=new Reservation(reservationID,userID,restuarantID,tableID,start,end);
		this.reservations.put(r.ID, r);
		reservationID++;
		return r.ID;
	}
	public boolean cancel(int reservationID){
		if(!this.reservations.containsKey(reservationID)){
			return false;
		}
		Reservation curr=this.reservations.get(reservationID);
		Restuarant r=this.restuarants.get(curr.restuarantID);
		r.cancelReservation(curr);
		return true;
	}
}

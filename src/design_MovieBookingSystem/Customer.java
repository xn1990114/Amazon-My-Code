package design_MovieBookingSystem;

import java.util.*;

public class Customer extends User{
	Set<Reservation> reservations;
	public Customer(String userName, String password, BookingSystem sys) {
		super(userName, password, sys);
		this.reservations=new HashSet<Reservation>();
	}
	
	public boolean addReservation(Reservation r){
		if(this.reservations.contains(r)||!this.userName.equals(r.userName)){
			return false;
		}
		this.reservations.add(r);
		return true;
	}
	
	public boolean removeReservation(Reservation r){
		if(this.reservations.contains(r)||!this.userName.equals(r.userName)){
			return false;
		}
		this.reservations.remove(r);
		return true;
	}
	
}

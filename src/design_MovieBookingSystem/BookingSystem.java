package design_MovieBookingSystem;

import java.util.*;

public class BookingSystem {
	Map<Integer, Movie> movies;
	Map<String, User> users;
	Map<Integer, Room> rooms;
	Map<Integer, Reservation> reservations;
	Set<Integer> activeUserIDs;

	public BookingSystem() {
		this.movies = new HashMap<Integer, Movie>();
		this.users = new HashMap<String, User>();
		this.rooms = new HashMap<Integer, Room>();
		this.reservations = new HashMap<Integer, Reservation>();
		this.activeUserIDs = new HashSet<Integer>();
	}

	public boolean makeReservation(String userName, int movieID, int time, int roomID, int seatID) {
		if (!this.users.containsKey(userName) || !this.movies.containsKey(movieID)
				|| !this.movies.get(movieID).playTime.containsKey(time)){
	
			return false;
		}
		User user=this.users.get(userName);
		if(user instanceof Admin||!this.activeUserIDs.contains(user.id)){
			return false;
		}
		Set<Play> p=this.movies.get(movieID).playTime.get(time);
		Play target=null;
		for(Play play:p){
			if(play.time==time){
				target=play;
				break;
			}
		}
		if(target==null){
			return false;
		}
		if(target.seats.get(seatID).assignedTo!=null){
			return false;
		}
		Reservation toadd=new Reservation(userName,target,seatID);
		this.reservations.put(toadd.id, toadd);
		Customer.class.cast(user).addReservation(toadd);
		target.seats.get(seatID).assignToUser(userName);
		return true;
	}
	
	public boolean cancelReservation(String userName,int reservationID){
		Reservation toCancel=this.reservations.get(reservationID);
		User user=this.users.get(userName);
		if(user==null||user instanceof Admin||!this.activeUserIDs.contains(user.id)){
			return false;
		}
		if(!Customer.class.cast(user).removeReservation(toCancel)){
			return false;
		}
		this.reservations.remove(reservationID);
		Play p=toCancel.play;
		p.seats.get(toCancel.seatID).removeUser();
		return true;
	}
	
	public boolean loginUser(String userName,String pw){
		if(!this.users.containsKey(userName)||!this.users.get(userName).password.equals(pw)){
			return false;
		}
		this.activeUserIDs.add(this.users.get(userName).id);
		return true;
	}
	public boolean logoffUser(String userName){
		User user=this.users.get(userName);
		if(user==null||!this.activeUserIDs.contains(user.id)){
			return false;
		}
		this.activeUserIDs.remove(user.id);
		return true;
	}
	public boolean addMovieSechdule(String userName,int movieID,int time,int roomID,int maxSeat){
		User user=this.users.get(userName);
		if(user==null||user instanceof Customer){
			return false;
		}
		Integer previousTime=this.rooms.get(roomID).playList.floorKey(time);
		Integer nextTime=this.rooms.get(roomID).playList.ceilingKey(time);
		if(previousTime!=null){
			Play prePlay=this.rooms.get(roomID).playList.get(previousTime);
			if(previousTime+this.movies.get(prePlay.movieID).duration+10>=time){
				return false;
			}
		}
		if(nextTime!=null){
			if(nextTime-10<=time+this.movies.get(movieID).duration){
				return false;
			}
		}
		Play toadd=new Play(movieID,time,roomID,time,this.rooms.get(roomID).maxSeatNum);
		this.rooms.get(roomID).addPlay(toadd);
		this.movies.get(movieID).addPlayTime(toadd);
		return true;
	}
	
	public boolean cancelMovieSechdule(Play p){
		Movie m=this.movies.get(p.movieID);
		Room r=this.rooms.get(p.roomID);
		if(m==null||r==null){
			return false;
		}
		m.removeTime(p);
		r.removePlay(p);
		notifyAllImpactedCustomer(p);
		return true;
	}

	private void notifyAllImpactedCustomer(Play p) {
		for(Seat s:p.seats){
			if(s.assignedTo!=null&&this.users.containsKey(s.assignedTo)){
				if(this.users.get(s.assignedTo) instanceof Admin){
					continue;
				}
				Customer u=(Customer)this.users.get(s.assignedTo);
				Set<Reservation> toremove=new HashSet<Reservation>();
				for(Reservation r:u.reservations){
					if(r.play==p){
						toremove.add(r);
					}
				}
				u.reservations.removeAll(toremove);
			}
		}
	}
	
	public void displayReservations(String userName){
		User u=this.users.get(userName);
		if(u==null||u instanceof Admin){
			return;
		}
		for(Reservation r:Customer.class.cast(u).reservations){
			System.out.println(r.id+":"+r.userName);
		}
	}
}

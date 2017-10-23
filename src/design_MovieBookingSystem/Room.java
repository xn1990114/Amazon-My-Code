package design_MovieBookingSystem;
import java.util.*;

public class Room {
	static int nextID=1;
	int id;
	int roomNum;
	TreeMap<Integer,Play> playList;
	int maxSeatNum;
	
	public Room(int roomNum,int maxSeatNum){
		this.roomNum=roomNum;
		this.id=nextID;
		nextID++;
		this.playList=new TreeMap<Integer,Play>();
		this.maxSeatNum=maxSeatNum;
	}
	
	public void addPlay(Play p){
		this.playList.put(p.time, p);
	}
	
	public boolean removePlay(Play p){
		if(!this.playList.containsKey(p.time)||this.playList.get(p.time)!=p){
			return false;
		}
		this.playList.remove(p.time);
		return true;
	}
}

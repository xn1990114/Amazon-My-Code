package design_MovieBookingSystem;
import java.util.*;

public class Movie {
	static int nextID=1;
	int id;
	String name;
	int duration;
	TreeMap<Integer,Set<Play>> playTime;
	
	public Movie(String name, int duration) {
		this.id = nextID;
		nextID++;
		this.name = name;
		this.duration = duration;
		this.playTime=new TreeMap<Integer,Set<Play>>();
	}
	
	public void addPlayTime(Play p){
		if(!this.playTime.containsKey(p.time)){
			this.playTime.put(p.time, new HashSet<Play>());
		}
		this.playTime.get(p.time).add(p);
	}
	
	public void removeTime(Play p){
		if(!this.playTime.containsKey(p.time)){
			return;
		}
		this.playTime.get(p.time).remove(p);
		if(this.playTime.get(p.time).isEmpty()){
			this.playTime.remove(p.time);
		}
	}
	
}

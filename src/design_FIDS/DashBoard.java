package design_FIDS;
import java.util.*;

public class DashBoard {
	TreeSet<Flight> flights;
	public DashBoard(){
		this.flights=new TreeSet<Flight>();
	}
	public void removeObsolete(long time){
		Iterator<Flight> it=this.flights.iterator();
		while(it.hasNext()){
			Flight f=it.next();
			if(f.ET>=time){
				break;
			}
			it.remove();
		}
	}
	
	public void addFlgiht(Flight f){
		this.flights.add(f);
	}
	
	public void updateSeq(Flight f){
		this.flights.remove(f);
		this.flights.add(f);
	}
	public void display(){
		Iterator<Flight> it=this.flights.iterator();
		while(it.hasNext()){
			Flight f=it.next();
			System.out.println(f.toString());
		}
	}
}

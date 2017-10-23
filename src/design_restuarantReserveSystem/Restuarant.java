package design_restuarantReserveSystem;

import java.util.*;


public class Restuarant {
	int ID;
	String name;
	Map<Integer,TreeSet<Integer>> availableTable;
	public Restuarant(int ID,String name,int maxTable){
		this.ID=ID;
		this.name=name;
		this.availableTable=new HashMap<Integer,TreeSet<Integer>>();
		for(int i=1;i<=maxTable;i++){
			this.availableTable.put(i, new TreeSet<Integer>());
		}
	}
	
	public boolean reserveTable(int tableID,int start,int end){
		if(this.availableTable.get(tableID).ceiling(start)<end||this.availableTable.get(tableID).floor(end)>start){
			return false;
		}
		for(int i=start;i<end;i++){
			this.availableTable.get(tableID).add(i);
		}
		return true;
	}
	public void cancelReservation(Reservation r){
		for(int i=r.startTime;i<r.endTime;i++){
			this.availableTable.get(r.tableID).remove(i);
		}
	}
}

package design_TicketBooking;

import java.util.Arrays;

public class TicketData {
	String type;
	long time;
	boolean[][] seatAvailable;
	int countLeft;
	public TicketData(String type,long time,int r,int c){
		this.type=type;
		this.time=time;
		this.seatAvailable=new boolean[r+1][c+1];
		for(int i=1;i<this.seatAvailable.length;i++){
			Arrays.fill(this.seatAvailable[i], true);
		}
		this.countLeft=r*c;
	}
	
	public boolean available(){
		return this.countLeft>0;
	}
	
	public boolean bookSeat(int r,int c){
		if(r<1||r>=this.seatAvailable.length||c<1||c>=this.seatAvailable[0].length){
			return false;
		}
		if(!this.seatAvailable[r][c]){
			return false;
		}
		this.seatAvailable[r][c]=false;
		this.countLeft--;
		return true;
	}
	
	public boolean cancelSeat(int r,int c){
		if(r<1||r>=this.seatAvailable.length||c<1||c>=this.seatAvailable[0].length){
			return false;
		}
		if(this.seatAvailable[r][c]){
			return false;
		}
		this.seatAvailable[r][c]=true;
		this.countLeft++;
		return true;
	}
}

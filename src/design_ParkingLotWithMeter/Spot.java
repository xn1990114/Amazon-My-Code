package design_ParkingLotWithMeter;

public class Spot {
	int ID;
	int checkedInTime;
	String PlateNum;
	public Spot(int ID){
		this.ID=ID;
		this.checkedInTime=-1;
		this.PlateNum="";
	}
	public boolean ParkCar(int time,String PlateNum){
		if(this.checkedInTime>0){
			return false;
		}
		this.checkedInTime=time;
		this.PlateNum=PlateNum;
		return true;
	}
	public int checkOut(int time,FeeSchedule fees){
		if(this.checkedInTime==-1){
			return -1;
		}
		int res=0;
		int nextdaystart=(this.checkedInTime/24+1)*24;
		int lastdayend=(time/24)*24;
		if(nextdaystart==lastdayend+24){
			if(time-this.checkedInTime>4){
				return fees.dailyFee[(this.checkedInTime/24)%7];
			}
			else{
				return fees.hourlyFee[(this.checkedInTime/24)%7]*(time-this.checkedInTime);
			}
		}
		int diff=nextdaystart-this.checkedInTime/24*24;
		if(diff>4){
			res=res+fees.dailyFee[(this.checkedInTime/24)%7];
		}
		else{
			res=res+fees.hourlyFee[(this.checkedInTime/24)%7]*diff;
		}
		diff=time-lastdayend;
		if(diff>4){
			res=res+fees.dailyFee[time/24%7];
		}
		else{
			res=res+fees.hourlyFee[time/24%7]*diff;
		}
		for(int i=nextdaystart;i<=lastdayend;i++){
			res=res+fees.dailyFee[(i/24)%7];
		}
		this.checkedInTime=-1;
		this.PlateNum="";
		return res;
	}
}

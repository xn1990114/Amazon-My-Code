package design_ParkingLotWithMeter;

import java.util.Calendar;
public class ParkingLotManager {
	FeeSchedule fees;
	Calendar cal;
	Spot[][] spots;
	public ParkingLotManager(int level,int spotNum,int h,int he,int weekday,int weekend){
		this.cal=Calendar.getInstance();
		this.fees=new FeeSchedule(h,he,weekday,weekend);
		this.spots=new Spot[level][spotNum];
		for(int i=0;i<this.spots.length;i++){
			for(int j=0;j<this.spots[i].length;j++){
				spots[i][j]=new Spot(i*100+j);
			}
		}
	}
	public boolean parkCar(String plateNum,int spotID,int time){
		return spots[spotID/100][spotID%100].ParkCar(time, plateNum);
	}
	public int calCharge(int spotID){
		return spots[spotID/100][spotID%100].checkOut(spotID, fees);
	}
}

package design_ParkingLotWithMeter;

public class FeeSchedule {
	int[] hourlyFee;
	int[] dailyFee;
	public FeeSchedule(int h,int he,int weekday,int weekend){
		this.hourlyFee=new int[]{h,h,h,h,h,he,he};
		this.hourlyFee=new int[]{weekday,weekday,weekday,weekday,weekday,weekend,weekend};
	}
}

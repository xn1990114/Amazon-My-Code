package design_Intersection;

public class Sensor {
	public static final int noTraffic=0;
	public static final int haveTraffic=1;
	public static final int haveTrafficWithLeft=2;
	
	int status;
	public Sensor(){
		this.status=Sensor.noTraffic;
	}
	public void setStatus(int status){
		this.status=status;
	}
	public void reset(){
		this.status=0;
	}
}

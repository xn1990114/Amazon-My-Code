package design_Intersection;

public class TrafficLight {
	public static final int Red=0;
	public static final int Green=1;
	public static final int GreenOnLeft=2;
	
	public int status;
	public int timer;
	public TrafficLight(){
		this.status=0;
		this.timer=0;
	}
	
	public void setStatus(int status,int time){
		this.status=status;
		this.timer=time;
	}
	
	
	public void addTimer(){
		this.timer=this.timer+5;
	}
}

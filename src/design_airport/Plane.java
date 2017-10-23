package design_airport;

public abstract class Plane {
	public static int Large=1;
	public static int Small=0;
	public static int Landing=0;
	public static int TakingOff=1;
	public String id;
	public int scheduledTime;
	public int size;
	public int intendedAction;
	public RunWay location;
	public void enterRunWay(RunWay rw){
		this.location=rw;
	}
	public  void takeoff(){
		this.location=null;
	}
	public void park(){
		this.location=null;
	}
	public void onHold(int delay){
		this.scheduledTime=this.scheduledTime+delay;
	}
}

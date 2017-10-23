package design_airport;

public class SmallPlane extends Plane{
	public SmallPlane(String id,int schedule,int actionType){
		this.id=id;
		this.intendedAction=actionType;
		this.scheduledTime=schedule;
		this.size=Plane.Small;
	}
	
}

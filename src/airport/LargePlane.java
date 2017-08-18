package airport;

public class LargePlane extends Plane{
	public LargePlane(String id,int schedule,int actionType){
		this.id=id;
		this.intendedAction=actionType;
		this.scheduledTime=schedule;
		this.size=Plane.Large;
	}
}

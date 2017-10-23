package design_airport;

public class RunWay {
	public int id;
	public Plane occupiedPlane;
	public RunWay(int id){
		this.id=id;
	}
	public void removePlane(){
		this.occupiedPlane=null;
	}
	public void addPlane(Plane p){
		this.occupiedPlane=p;
	}
}

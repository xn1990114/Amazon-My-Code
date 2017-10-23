package design_Elevator;

public class Elevator {
	int ID;
	int currLocation;
	Direction currDirection;
	int currDestination;
	ElevatorController controller;
	public Elevator(int id){
		this.ID=id;
		this.currDestination=0;
		this.currDirection=Direction.STAY;
		this.currLocation=0;
	}
	
	public boolean moveTo(int floor){
		if(this.currLocation==floor){
			return false;
		}
		if(this.currLocation<floor){
			this.currDirection=Direction.UP;
		}
		else{
			this.currDirection=Direction.DOWN;
		}
		this.currDestination=floor;
		return true;
	}
	public void arrive(){
		this.currLocation=this.currDestination;
		this.controller.recordArrival(this);
		
		if(this.currDestination==this.currLocation){
			this.currDirection=Direction.STAY;
		}
	}
}

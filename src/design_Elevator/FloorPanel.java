package design_Elevator;

public class FloorPanel {
	public static int noActive=0;
	public static int upActive=1;
	public static int downActive=2;
	public static int bothActive=3;
	
	int floor;
	int activeDirection;
	ElevatorController controller;
	
	
	public FloorPanel(int floor, ElevatorController controller) {
		super();
		this.floor = floor;
		this.activeDirection =0;
		this.controller = controller;
	}


	public void addDirectionToController(int dir){
		if(this.activeDirection==3){
			return;
		}
		if(this.activeDirection==dir){
			return;
		}
		this.activeDirection=this.activeDirection+dir;
		this.controller.addDestination(this,dir);
	}
	
	public void removeDirection(int dir){
		if(this.activeDirection==3){
			this.activeDirection=this.activeDirection-dir;
		}
		else if(this.activeDirection==dir){
			this.activeDirection=0;
		}
	}
	
}

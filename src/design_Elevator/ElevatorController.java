package design_Elevator;
import java.util.*;

public class ElevatorController {
	List<Elevator> elevators;
	List<FloorPanel> floors;
	List<TreeSet<Integer>> destinations;
	Set<FloorPanel> activeDownFloors;
	Set<FloorPanel> activeUpFloors;
	
	
	public void addDestination(FloorPanel floorPanel, int dir) {
		if(dir==1){
			int temp=-1;
			int i=0;
			while(i<elevators.size()){
				Elevator e=this.elevators.get(i);
				if(e.currDirection==Direction.UP&&e.currDestination<floorPanel.floor){
					temp=i;
					break;
				}
				else if(e.currDirection==Direction.STAY){
					temp=i;
				}
				else {
					if(temp==-1){
						temp=i;
					}
				}
				i++;
			}
			this.destinations.get(temp).add(floorPanel.floor);
			this.activeUpFloors.add(floorPanel);
			if(this.elevators.get(temp).currDirection==Direction.STAY){
				setElevatorDestination(this.elevators.get(temp));
			}
		}
		else if(dir==2){
			int temp=-1;
			int i=0;
			while(i<elevators.size()){
				Elevator e=this.elevators.get(i);
				if(e.currDirection==Direction.DOWN&&e.currDestination>floorPanel.floor){
					temp=i;
					break;
				}
				else if(e.currDirection==Direction.STAY){
					temp=i;
				}
				else {
					if(temp==-1){
						temp=i;
					}
				}
				i++;
			}
			this.destinations.get(temp).add(floorPanel.floor);
			this.activeDownFloors.add(floorPanel);
			if(this.elevators.get(temp).currDirection==Direction.STAY){
				setElevatorDestination(this.elevators.get(temp));
			}
		}
	}

	private void setElevatorDestination(Elevator elevator) {
		if(this.destinations.get(elevator.ID).isEmpty()){
			return;
		}
		TreeSet<Integer> des=this.destinations.get(elevator.ID);
		if(elevator.currDirection==Direction.STAY){
			Integer up=des.ceiling(elevator.currLocation+1);
			if(up!=null){
				elevator.moveTo(up);
				return;
			}
			Integer down=des.floor(elevator.currLocation-1);
			if(down!=null){
				elevator.moveTo(down);
				return;
			}
		}
		else if(elevator.currDirection==Direction.UP){
			Integer next=des.ceiling(elevator.currLocation+1);
			if(next==null){
				elevator.currDirection=Direction.STAY;
				setElevatorDestination(elevator);
			}
			else{
				this.destinations.get(elevator.ID).remove(next);
				elevator.moveTo(next);
			}
		}
		else if(elevator.currDirection==Direction.DOWN){
			Integer next=des.floor(elevator.currLocation-1);
			if(next==null){
				elevator.currDirection=Direction.STAY;
				setElevatorDestination(elevator);
			}
			else{
				this.destinations.get(elevator.ID).remove(next);
				elevator.moveTo(next);
			}
		}
	}

	public void recordArrival(Elevator elevator) {
		if(elevator.currDirection==Direction.UP){
			this.activeUpFloors.remove(this.floors.get(elevator.currLocation));
			this.floors.get(elevator.currLocation).removeDirection(1);
		}
		else{
			this.activeDownFloors.remove(this.floors.get(elevator.currLocation));
			this.floors.get(elevator.currLocation).removeDirection(2);
		}
		this.setElevatorDestination(elevator);
	}
}

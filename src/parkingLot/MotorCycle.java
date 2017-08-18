package parkingLot;

import java.util.ArrayList;

public class MotorCycle extends Vehicle{
	public MotorCycle(String plate){
		this.Plate=plate;
		this.size=Vehicle.Size_MotorCycle;
		this.parkingLevel=0;
		this.parkingNum=new ArrayList<Integer>();
	}
}

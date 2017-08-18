package parkingLot;

import java.util.ArrayList;

public class Bus extends Vehicle {
	public Bus(String plate){
		this.Plate=plate;
		this.size=Vehicle.Size_Bus;
		this.parkingLevel=0;
		this.parkingNum=new ArrayList<Integer>();
	}
}

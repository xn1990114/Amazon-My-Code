package design_parkingLot;

import java.util.ArrayList;

public class Car extends Vehicle{
	public Car(String plate){
		this.Plate=plate;
		this.size=Vehicle.Size_Car;
		this.parkingLevel=0;
		this.parkingNum=new ArrayList<Integer>();
	}
}

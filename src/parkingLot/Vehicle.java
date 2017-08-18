package parkingLot;
import java.util.*;

public abstract class Vehicle {
	public static int Size_MotorCycle=0;
	public static int Size_Car=1;
	public static int Size_Bus=2;
	public String Plate;
	public int size;
	public int parkingLevel;
	public int parkingRow;
	public List<Integer> parkingNum=new ArrayList<Integer>();
	public void parkVechile(int level,int row,int num){
		this.parkingLevel=level;
		this.parkingRow=row;
		this.parkingNum.add(num);
	}
	public void removeVechile(){
		this.parkingRow=-1;
		this.parkingLevel=-1;
		this.parkingNum.clear();;
	}
}

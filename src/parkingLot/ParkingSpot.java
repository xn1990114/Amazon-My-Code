package parkingLot;

public class ParkingSpot {
	public static int Size_MotorCycle=0;
	public static int Size_Car=1;
	public static int Size_Bus=2;
	public int level;
	public int size;
	public int row;
	public int num;
	public boolean occuplied;
	public String parkedCarPlate;
	public ParkingSpot(int row,int num,int level,int size){
		this.row=row;
		this.num=num;
		this.level=level;
		this.size=size;
		this.occuplied=false;
		this.parkedCarPlate=null;
	}
	public void parkCar(Vehicle v){
		this.occuplied=true;
		this.parkedCarPlate=v.Plate;
		v.parkVechile(level,row, num);
	}
	public void removeCar(){
		this.occuplied=false;
		this.parkedCarPlate=null;
	}
}

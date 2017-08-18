package parkingLot;
import java.util.*;

public class ParkingManager {
	List<Level> levels;
	public ParkingManager(int lv,int row,int num){
		this.levels=new ArrayList<Level>();
		for(int i=0;i<lv;i++){
			levels.add(new Level(i,row,num));
		}
	}
	public boolean parkVehicle(Vehicle v){
		for(int i=0;i<levels.size();i++){
			if(levels.get(i).parkVehicle(v)){
				return true;
			}
		}
		return false;
	}
	public boolean removeCar(Vehicle v){
		int lv=v.parkingLevel;
		return this.levels.get(lv).remove(v);
	}
}

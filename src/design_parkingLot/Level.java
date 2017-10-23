package design_parkingLot;

import java.util.*;

public class Level {
	List<List<ParkingSpot>> parkingLots;
	int currLevel;

	public Level(int l, int maxRow, int maxNum) {
		this.currLevel = l;
		this.parkingLots = new ArrayList<List<ParkingSpot>>();
		for (int i = 0; i < maxRow; i++) {
			this.parkingLots.add(new ArrayList<ParkingSpot>());
			for(int j=0;j<maxNum;j++){
				this.parkingLots.get(i).add(new ParkingSpot(i,j,l,1));
			}
		}
	}

	public boolean parkVehicle(Vehicle v){
		if(v.size<ParkingSpot.Size_Bus){
			for(int i=0;i<this.parkingLots.size();i++){
				for(ParkingSpot p:this.parkingLots.get(i)){
					if(!p.occuplied){
						p.parkCar(v);
						return true;
					}
				}
			}
		}
		else{
			for(int i=0;i<this.parkingLots.size();i++){
				int first=find5Consecutive(this.parkingLots.get(i));
				if(first>=0){
					for(int j=first;j<first+5;j++){
						this.parkingLots.get(i).get(j).parkCar(v);
					}
					return true;
				}
			}
			
		}
		return false;
	}
	public boolean remove(Vehicle v){
		if(v.parkingLevel==-1){
			return false;
		}
		List<ParkingSpot> row=this.parkingLots.get(v.parkingRow);
		for(ParkingSpot p:row){
			p.removeCar();
		}
		v.removeVechile();
		return true;
	}
	public int find5Consecutive(List<ParkingSpot> list){
		int currCount=0;
		for(int i=0;i<list.size();i++){
			if(!list.get(i).occuplied){
				currCount++;
				if(currCount==5){
					return i-4;
				}
			}
			else{
				currCount=0;
			}
		}
		return -1;
	}
}

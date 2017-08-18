package wareHouse2;
import java.util.*;

public class Truck {
	int ID;
	WareHouse destination;
	Map<Integer,Integer> cargo;
	int load;
	public Truck(int ID){
		this.ID=ID;
		this.destination=null;
		this.cargo=new HashMap<Integer,Integer>();
	}
	public boolean loadItem(int UPC,int qty){
		if(this.load+qty>500){
			return false;
		}
		if(!this.cargo.containsKey(UPC)){
			this.cargo.put(UPC, 0);
		}
		this.cargo.put(UPC, this.cargo.get(UPC)+qty);
		return true;
	}
	public boolean unLoadItem(int UPC,int qty){
		if(!this.cargo.containsKey(ID)||this.cargo.get(ID)<qty){
			return false;
		}
		this.cargo.remove(UPC);
		return true;
	}
	public boolean setDestination(WareHouse wh){
		if(this.destination!=null){
			return false;
		}
		this.destination=wh;
		return true;
	}
	
}

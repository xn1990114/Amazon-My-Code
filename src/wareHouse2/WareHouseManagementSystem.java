package wareHouse2;
import java.util.*;
/*
 * 算是OOD题吧,设计整个亚马逊的物品、仓库、卡车互动系统.仓库遍布美国,卡车有油量,仓库之间 
 * 有些有路径有些没有.我搞了几个类,包括物品、仓库、卡车.要求实现一些功能诸如,从仓库A把一 定的物品分给仓库B,分派卡车,
 * 装货、卸货函数.
 */
public class WareHouseManagementSystem {
	Map<Integer,Item> items;
	Map<Integer,Truck> trucks;
	Map<Integer,WareHouse> wareHouses;
	public WareHouseManagementSystem(){
		this.items=new HashMap<Integer,Item>();
		this.trucks=new HashMap<Integer,Truck>();
		this.wareHouses=new HashMap<Integer,WareHouse>();
	}
	public boolean addNewWareHouse(int ID,String address){
		if(this.wareHouses.containsKey(ID)){
			return false;
		}
		this.wareHouses.put(ID, new WareHouse(ID,address,this));
		return true;
	}
	public boolean sentItemBetweenWareHouse(int source,int destin,int UPC,int qty){
		if(!this.wareHouses.containsKey(source)||this.wareHouses.containsKey(destin)){
			return false;
		}
		WareHouse s=this.wareHouses.get(source);
		if(!s.checkRoute(this.wareHouses.get(destin))){
			return false;
		}
		if(s.trucks.isEmpty()){
			return false;
		}
		Truck t=s.trucks.get(s.trucks.size()-1);
		if(!s.loadTruck(t.ID, UPC, qty)){
			return false;
		}
		this.wareHouses.get(source).sendTruck(t.ID);
		return true;
	}
}

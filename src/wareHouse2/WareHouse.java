package wareHouse2;

import java.util.*;

public class WareHouse {
	int ID;
	String address;
	List<WareHouse> connectedWareHouse;
	Map<Integer,Truck> trucks;
	Map<Integer,Integer> stock;
	WareHouseManagementSystem manager;
	public WareHouse(int iD, String address,WareHouseManagementSystem manager) {
		super();
		ID = iD;
		this.address = address;
		this.connectedWareHouse = new ArrayList<WareHouse>();
		this.trucks = new HashMap<Integer,Truck>();
		this.stock = new HashMap<Integer,Integer>();
		this.manager=manager;
	}
	public boolean addConnection(WareHouse wh){
		if(this.connectedWareHouse.contains(wh)){
			return false;
		}
		this.connectedWareHouse.add(wh);
		return true;
	}
	public void removeConnection(WareHouse wh){
		this.connectedWareHouse.remove(wh);
	}
	public boolean loadTruck(int ID,int UPC,int qty){
		if(this.stock.get(UPC)<qty||!this.trucks.containsKey(ID)){
			return false;
		}
		if(!this.trucks.get(ID).loadItem(UPC,qty)){
			return false;
		}
		this.stock.put(UPC,this.stock.get(UPC)-qty);
		if(this.stock.get(UPC)==0){
			this.stock.remove(UPC);
		}
		return true;
	}
	public boolean sendTruck(int ID){
		if(!this.trucks.containsKey(ID)||this.trucks.get(ID).destination==null){
			return false;
		}
		this.trucks.remove(ID);
		return true;
	}
	public boolean receiveTruck(int ID){
		if(this.trucks.containsKey(ID)){
			return false;
		}
		this.trucks.put(ID,this.manager.trucks.get(ID));
		this.trucks.get(ID).destination=null;
		return true;
	}
	public boolean unloadTruck(int ID,int UPC,int qty){
		if(!this.trucks.containsKey(ID)){
			return false;
		}
		if(!this.trucks.get(ID).unLoadItem(UPC,qty)){
			return false;
		}
		if(!this.stock.containsKey(UPC)){
			this.stock.put(UPC, 0);
		}
		this.stock.put(UPC,this.stock.get(UPC)+qty);
		return true;
	}
	public boolean checkRoute(WareHouse destin){
		Set<WareHouse> visited=new HashSet<WareHouse>();
		Queue<WareHouse> qu=new LinkedList<WareHouse>();
		qu.offer(this);
		visited.add(this);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				WareHouse curr=qu.poll();
				if(curr==destin){
					return true;
				}
				for(WareHouse child:curr.connectedWareHouse){
					if(!visited.contains(child)){
						visited.add(child);
						qu.offer(child);
					}
				}
			}
		}
		return false;
	}
}

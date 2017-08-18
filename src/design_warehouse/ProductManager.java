package design_warehouse;
import java.util.*;

public class ProductManager {
	// product id to stock qty
	Map<Integer,Integer> stock;
	// product id to product obj
	Map<Integer,Product> productMap;
	public ProductManager(){
		this.stock=new HashMap<Integer,Integer>();
		this.productMap=new HashMap<Integer,Product>();
	}
	public boolean addProduct(Product p){
		if(this.productMap.containsKey(p.id)){
			return false;
		}
		this.productMap.put(p.id, p);
		return true;
	}
	public boolean changeQty(int pid,int qty){
		if(this.productMap.containsKey(pid)){
			return false;
		}
		if(this.stock.containsKey(pid)){
			this.stock.put(pid, qty+this.stock.get(pid));
		}
		else{
			this.stock.put(pid, qty);
		}
		return true;
	}
	public boolean checkInSupplyOrder(Order o){
		if(o.status!=Order.fullfilled){
			return false;
		}
		for(int id:o.content.keySet()){
			if(!this.productMap.containsKey(id)){
				return false;
			}
		}
		for(int id:o.content.keySet()){
			this.changeQty(id, o.content.get(id));
		}
		o.status=Order.closed;
		return true;
	}
	public boolean checkInCustomerOrder(Order o){
		if(o.status!=Order.fullfilled){
			return false;
		}
		for(int id:o.content.keySet()){
			if(!this.productMap.containsKey(id)||!this.stock.containsKey(id)||this.stock.get(id)<o.content.get(id)){
				return false;
			}
		}
		for(int id:o.content.keySet()){
			this.changeQty(id, -o.content.get(id));
		}
		o.status=Order.closed;
		return true;
	}
}

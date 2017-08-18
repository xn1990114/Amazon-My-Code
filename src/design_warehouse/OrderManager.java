package design_warehouse;
import java.util.*;

public class OrderManager {
	Map<Integer,Order> currOrders;
	Map<Integer,Order> oldOrders;
	public OrderManager(){
		this.currOrders=new HashMap<Integer,Order>();
		this.oldOrders=new HashMap<Integer,Order>();
	}
	public Order makeOrder(int type){
		if(type==Order.TYPE_CUSTOMER){
			Order o=new CustomerOrder();
			this.currOrders.put(o.orderNum, o);
			return o;
		}
		else{
			Order o=new SupplyOrder();
			this.currOrders.put(o.orderNum, o);
			return o;
		}
	}
	public boolean changeQty(int id,int pid,int qty){
		if(!this.currOrders.containsKey(id)){
			return false;
		}
		Order o=this.currOrders.get(id);
		if(o.content.containsKey(pid)){
			o.content.put(pid, o.content.get(pid)+qty);
		}
		else{
			o.content.put(pid, qty);
		}
		if(o.content.get(pid)==0){
			o.content.remove(pid);
		}
		if(o.content.isEmpty()){
			cancelOrder(o.orderNum);
		}
		return true;
	}
	public boolean cancelOrder(int oid){
		if(!this.currOrders.containsKey(oid)){
			return false;
		}
		Order o=this.currOrders.get(oid);
		this.currOrders.remove(oid);
		this.oldOrders.put(oid, o);
		return true;
	}
	public Order fullFillOrder(int oid){
		if(!this.currOrders.containsKey(oid)){
			return null;
		}
		this.currOrders.get(oid).status=Order.fullfilled;
		return this.currOrders.get(oid);
	}
	public boolean closeOrder(int oid){
		if(!this.currOrders.containsKey(oid)){
			return false;
		}
		Order o=this.currOrders.get(oid);
		this.currOrders.remove(oid);
		this.oldOrders.put(oid, o);
		return true;
	}
}

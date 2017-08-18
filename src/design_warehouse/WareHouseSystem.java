package design_warehouse;
import java.util.*;

public class WareHouseSystem {
	OrderManager om;
	ProductManager pm;
	Queue<Order> orderQueue;
	public WareHouseSystem(){
		this.om=new OrderManager();
		this.pm=new ProductManager();
		this.orderQueue=new LinkedList<Order>();
	}
	public int placeOrder(int Type){
		Order o=this.om.makeOrder(Type);
		return o.orderNum;
	}
	public boolean changeQty(int oid,int pid,int qty){
		return this.om.changeQty(oid, pid, qty);
	}
	public boolean fullFillOrder(int oid){
		Order o=this.om.fullFillOrder(oid);
		if(o==null){
			return false;
		}
		this.orderQueue.offer(o);
		return true;
	}
	public boolean checkInOrder(int oid){
		Order o=this.orderQueue.poll();
		if(o instanceof CustomerOrder){
			if(this.pm.checkInCustomerOrder(o)){
				this.om.closeOrder(o.orderNum);
				return true;
			}
		}
		else{
			if(this.pm.checkInSupplyOrder(o)){
				this.om.closeOrder(o.orderNum);
				return true;
			}
		}
		return false;
	}
}

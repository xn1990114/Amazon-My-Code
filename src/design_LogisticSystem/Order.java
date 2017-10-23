package design_LogisticSystem;
import java.util.*;

public class Order {
	int id;
	Map<Integer,Integer> items;
	OrderStatus status;
	int userID;
	int adminID;
	String address;
	int paymentDue;
	
	
	public Order(int id, int userID, String address) {
		this.id = id;
		this.userID = userID;
		this.address = address;
		this.items=new HashMap<Integer,Integer>();
		this.paymentDue=0;
		this.status=OrderStatus.Pending;
	}
	public void addItem(int upc){
		if(!this.items.containsKey(upc)){
			this.items.put(upc, 0);
		}
		this.items.put(upc, 1+this.items.get(upc));
	}
	public void updateBalance(int amount){
		this.paymentDue=this.paymentDue+amount;
	}
	public void updateAddress(String newAddress){
		this.address=newAddress;
	}
	public void confirmItems(){
		this.status=OrderStatus.Confirmed;
	}
	public void assignAdmin(int adminID){
		this.adminID=adminID;
	}
	public void shipOrder(){
		this.status=OrderStatus.Shipped;
	}
	public void Delivered(){
		this.status=OrderStatus.Closed;
	}
	public void cancel(){
		this.status=OrderStatus.Cancelled;
	}
}

package design_LogisticSystem;

import java.util.ArrayList;

public class Customer extends User{
	
	public Customer(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.myOrders=new ArrayList<Order>();
	}
	public void placeOrder(Order order){
		this.myOrders.add(order);
	}
	public void cancelOrder(Order order){
		this.myOrders.remove(order);
	}
}

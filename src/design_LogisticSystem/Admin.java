package design_LogisticSystem;

import java.util.*;

public class Admin extends User{
	int fee;
	public Admin(int id, String userName, String password,int fee) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.myOrders=new ArrayList<Order>();
		this.fee=fee;
	}
	public void removeOrder(Order order){
		this.myOrders.remove(order);
	}
	public void assignOrder(Order order){
		this.myOrders.add(order);
	}
}

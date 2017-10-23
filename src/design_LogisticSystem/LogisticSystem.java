package design_LogisticSystem;
import java.util.*;

public class LogisticSystem {
	Map<Integer,Item> items;
	Map<Integer,User> users;
	Map<Integer,Order> orders;
	public LogisticSystem(){
		this.items=new HashMap<Integer,Item>();
		this.users=new HashMap<Integer,User>();
		this.orders=new HashMap<Integer,Order>();
	}
	public boolean addNewItem(int upc,String name,int price){
		if(this.items.containsKey(upc)){
			return false;
		}
		Item toadd=new Item(upc,name,price);
		this.items.put(toadd.upc, toadd);
		return true;
	}
	public boolean addCustomer(int id,String userName,String password){
		if(this.users.containsKey(id)){
			return false;
		}
		User toadd=new Customer(id,userName,password);
		this.users.put(id, toadd);
		return true;
	}
	public boolean addAdmin(int id,String userName,String password,int fee){
		if(this.users.containsKey(id)){
			return false;
		}
		User toadd=new Admin(id,userName,password,fee);
		this.users.put(id, toadd);
		return true;
	}
	public boolean createOrder(int id,int userID,String address){
		if(this.orders.containsKey(id)){
			return false;
		}
		if(this.users.get(userID) instanceof Admin){
			return false;
		}
		Order newOrder=new Order(id,userID,address);
		Customer.class.cast(this.users.get(userID)).placeOrder(newOrder);
		this.orders.put(id, newOrder);
		return true;
	}
	public boolean addItemToOrder(int userID,int orderID,int itemUPC){
		if(!this.users.containsKey(userID)||!this.orders.containsKey(orderID)||!this.items.containsKey(itemUPC)){
			return false;
		}
		if(this.orders.get(orderID).userID!=userID){
			return false;
		}
		if(this.users.get(userID) instanceof Admin){
			return false;
		}
		this.orders.get(orderID).addItem(itemUPC);
		this.orders.get(orderID).updateBalance(this.items.get(itemUPC).price);
		return true;
	}
	public boolean confirmOrder(int userID,int orderID,int adminID){
		if(!this.users.containsKey(userID)||!this.orders.containsKey(orderID)||!this.users.containsKey(adminID)){
			return false;
		}
		if(this.orders.get(orderID).userID!=userID){
			return false;
		}
		if(this.users.get(userID) instanceof Admin||this.users.get(adminID) instanceof Customer){
			return false;
		}
		this.orders.get(orderID).confirmItems();
		return true;
	}
	public boolean assignAdmin(int adminID,int orderID){
		Order o=this.orders.get(orderID);
		User u=this.users.get(adminID);
		if(o==null||o.adminID!=0||u==null||u instanceof Customer){
			return false;
		}
		Admin.class.cast(u).assignOrder(o);
		o.assignAdmin(adminID);
		return true;
	}
	public boolean confirmDelivery(int orderID){
		if(!this.orders.containsKey(orderID)){
			return false;
		}
		Order o=this.orders.get(orderID);
		o.Delivered();
		Admin.class.cast(this.users.get(o.adminID)).removeOrder(o);
		return true;
	}
	public boolean cancelOrder(int userID,int orderID){
		Order o=this.orders.get(orderID);
		User u=this.users.get(userID);
		if(o==null||o.adminID!=0||u==null||u instanceof Admin){
			return false;
		}
		Customer.class.cast(u).cancelOrder(o);
		o.cancel();
		return true;
	}
	public OrderStatus checkOrderStatus(int orderID){
		if(!this.orders.containsKey(orderID)){
			return null;
		}
		return this.orders.get(orderID).status;
	}
}

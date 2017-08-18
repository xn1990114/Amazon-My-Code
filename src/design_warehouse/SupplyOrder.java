package design_warehouse;

import java.util.*;

public class SupplyOrder extends Order {
	public SupplyOrder(){
		this.orderNum=Order.orderID;
		this.content=new HashMap<Integer,Integer>();
		this.status=Order.open;
		Order.orderID++;
	}
	public void addItem(int productID,int productQty){
		if(productQty<=0){
			return;
		}
		if(!this.content.containsKey(productID)){
			this.content.put(productID, productQty);
		}
		else{
			this.content.put(productID, productQty+this.content.get(productID));
		}
	}
	@Override
	public boolean fullFillOrder() {
		if(this.status!=Order.open){
			return false;
		}
		this.status=Order.fullfilled;
		return true;
	}

	@Override
	public int getOrderNum() {
		return this.orderNum;
	}

	@Override
	public boolean cancelOrder() {
		if(this.status!=Order.open){
			return false;
		}
		this.status=Order.cancelled;
		return true;
	}
	
}

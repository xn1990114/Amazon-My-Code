package design_warehouse;

import java.util.Map;

public abstract class Order {
	static final int TYPE_SUPPLY=1;
	static final int TYPE_CUSTOMER=1;
	static final int open=1;
	static final int fullfilled=2;
	static final int cancelled=3;
	static final int closed=4;
	static public int orderID=1;
	Map<Integer,Integer> content;
	int orderNum;
	int status;
	public abstract boolean fullFillOrder();
	public abstract int getOrderNum();
	public abstract boolean cancelOrder();
}

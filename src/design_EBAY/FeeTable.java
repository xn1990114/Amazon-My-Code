package design_EBAY;
import java.util.*;

public class FeeTable {
	TreeMap<Integer,Integer> table;
	int fixedFee;
	
	public FeeTable() {
		this.table=new TreeMap<Integer,Integer>();
		this.fixedFee = 0;
	}
	
	public void updateVariableFeeAmount(int floor,int percentage){
		this.table.put(floor, percentage);
	}
	
	public void updateFixedFeeAmount(int fee){
		this.fixedFee=fee;
	}
}

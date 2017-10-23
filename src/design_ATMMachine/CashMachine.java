package design_ATMMachine;
import java.util.*;

public class CashMachine {
	int[] billFaceValue;
	int[] billLeft;
	
	public CashMachine(){
		this.billFaceValue=new int[]{100,500,1000,2000,5000,10000};
		this.billLeft=new int[6];
	}
	
	public void acceptBill(int amount){
		for(int i=0;i<billFaceValue.length;i++){
			if(billFaceValue[i]==amount){
				billLeft[i]++;
			}
		}
	}
	
	public boolean dispenseBill(int amount){
		int[] res=new int[this.billLeft.length];
		int index=this.billFaceValue.length-1;
		while(amount>0){
			if(amount<this.billFaceValue[index]){
				index--;
			}
			else{
				amount=amount-this.billFaceValue[index];
				res[index]++;
			}
		}
		if(amount>0){
			return false;
		}
		return true;
	}
}

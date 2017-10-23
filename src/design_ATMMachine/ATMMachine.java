package design_ATMMachine;
/*
 * ATM is a banking application developed to perform different banking services like cash deposits, 
 * cash withdrawls, balance enquiry, balance statements, change pin number etc.
 */
public class ATMMachine {
	Card activeCard;
	CashMachine cashMachine;
	int fee;
	
	public ATMMachine(int fee){
		this.cashMachine=new CashMachine();
		this.fee=fee;
	}
	public void setFee(int newFee){
		this.fee=newFee;
	}
	public boolean startTransaction(String cardNum,String pin){
		activeCard=this.validateCard(cardNum, pin);
		if(this.activeCard==null){
			return false;
		}
		return true;
	}
	public Card validateCard(String cardNum,String pin){
		//talk to authroizer and get card type etc.
		return new Card(cardNum,0);
	}
	public boolean withdrawCash(int amount){
		return this.cashMachine.dispenseBill(amount);
	}
	public void depositCash(int amount){
		this.cashMachine.acceptBill(amount);
	}
	public void resetTransaction(){
		this.activeCard=null;
	}
	public void updatePin(String newPin){
		this.activeCard.updatePin(newPin);
	}
	public void printStatement(){
		if(this.activeCard==null){
			System.out.println("no card inserted");
			return;
		}
		System.out.println(this.activeCard.balance);
	}
}

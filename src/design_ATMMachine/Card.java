package design_ATMMachine;

public class Card {
	String cardNum;
	int balance;
	int cardType;
	
	public Card(String cardNum,int cardType) {
		this.cardNum = cardNum;
		this.cardType=cardType;
	}

	public void updateBalance(int amount){
		this.balance=this.balance+amount;
	}
	public boolean updatePin(String newPin){
		if(this.cardType==0){
			// do something
			return true;
		}
		return false;
	}
}

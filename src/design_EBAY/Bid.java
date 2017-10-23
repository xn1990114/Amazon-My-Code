package design_EBAY;

public class Bid implements Comparable<Bid>{
	int bidID;
	int bidderID;
	int amount;
	int auctionID;
	
	public Bid(int bidderID, int amount, int auctionID,int bidID) {
		this.bidID=bidID;
		this.bidderID = bidderID;
		this.amount = amount;
		this.auctionID = auctionID;
	}
	public int compareTo(Bid b2){
		return this.amount-b2.amount;
	}
}

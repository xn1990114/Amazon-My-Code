package design_EBAY;
import java.util.*;

public class Auction {
	int auctionID;
	int sellerID;
	int expireTime;
	TreeSet<Bid> bids;
	int currPrice;
	int startPrice;
	public Auction(int auctionID,int sellerID, int expireTime, int startPrice) {
		this.auctionID=auctionID;
		this.sellerID = sellerID;
		this.expireTime = expireTime;
		this.currPrice = startPrice;
		this.bids=new TreeSet<Bid>();
		this.startPrice=startPrice;
	}
	
	public boolean addBid(Bid b){
		if(b.amount<=currPrice){
			return false;
		}
		this.bids.add(b);
		currPrice=b.amount;
		return true;
	}
	
	public boolean cancelBid(Bid b){
		if(this.bids.contains(b)){
			this.bids.remove(b);
			if(this.bids.isEmpty()){
				this.currPrice=this.startPrice;
			}
			else{
				this.currPrice=this.bids.last().amount;
			}
			return true;
		}
		return false;
	}
	
}

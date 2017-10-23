package design_EBAY;
import java.util.*;
/*
 * Ebay is a multinational e-commerce corporation, 
 * facilitating online consumer-to-consumer and business-to-consumer sales. 
 * The website is free to use for buyers, 
 * but sellers are charged fees for listing items and again when those items are sold. 
 * The sellers aution their items and buyers bid on items.
 */
public class EBAYSystem {
	static int userID=1;
	static int bidID=1;
	static int auctionsID=1;
	FeeTable feesSchedule;
	Map<Integer,User> users;
	Map<Integer,Auction> auctions;
	Map<Integer,Bid> bids;
	TreeSet<Auction> activeAuctions;
	
	
	public EBAYSystem() {
		this.feesSchedule = new FeeTable();
		this.users = new HashMap<Integer,User>();
		this.auctions = new HashMap<Integer,Auction>();
		this.bids = new HashMap<Integer,Bid>();
		this.activeAuctions = new TreeSet<Auction>();
	}
	public void createUser(String userName,String password,int type){
		User newUser=new User(userName,userID,password,type,this);
		userID++;
		this.users.put(newUser.userID, newUser);
	}
	public int createBid(User user, int amount, int auctionID) {
		if(user.activeBids.containsKey(auctionID)){
			if(this.bids.get(user.activeBids.get(auctionID)).amount>=amount){
				return -1;
			}
			user.activeBids.remove(auctionID);
		}
		Bid newBid=new Bid(user.userID,amount,auctionID,bidID);
		bidID++;
		return newBid.bidID;
	}
	
	public boolean cancelBid(int userID,int bidID){
		Bid toremove=this.bids.get(bidID);
		if(!this.activeAuctions.contains(this.auctions.get(toremove.auctionID))){
			return false;
		}
		this.auctions.get(toremove.auctionID).cancelBid(toremove);
		this.users.get(toremove.bidderID).activeBids.remove(toremove.auctionID);
		this.bids.remove(toremove.bidID);
		return true;
	}

	public int createAuctions(int expirationDate, int UPC, int startPrice, User user) {
		Auction toadd=new Auction(auctionsID,user.userID,expirationDate,startPrice);
		this.auctions.put(toadd.auctionID, toadd);
		auctionsID++;
		return toadd.auctionID;
	}

	public boolean cancelAutction(int auctionID) {
		Auction toremove=this.auctions.get(auctionID);
		if(!this.activeAuctions.contains(toremove)){
			return false;
		}
		this.activeAuctions.remove(toremove);
		for(Bid b:toremove.bids){
			this.users.get(b.bidderID).activeBids.remove(toremove.auctionID);
		}
		return true;
	}

	public void updateActiveAuctions(int time){
		Set<Auction> completed=new HashSet<Auction>();
		Iterator<Auction> it=this.activeAuctions.iterator();
		while(it.hasNext()){
			Auction curr=it.next();
			if(curr.expireTime<=time){
				completed.add(curr);
			}
			else{
				break;
			}
		}
		sendEmail(completed);
	}
	public void sendEmail(Set<Auction> completedAuction){
		for(Auction a:completedAuction){
			if(a.bids.isEmpty()){
				System.out.println(a.auctionID+"has No bid and email sent to seller ID: "+a.sellerID);
			}
			else{
				System.out.println(a.auctionID+"is completed and email sent to buyer"+ a.bids.iterator().next().bidderID);
			}
		}
	}
}

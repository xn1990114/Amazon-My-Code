package design_EBAY;
import java.util.*;

public class User {
	public static int BUSINESS=1;
	public static int INDIVIDUAL=0;
	int userID;
	String userName;
	String password;
	int type;
	EBAYSystem sys;
	Map<Integer,Integer> activeBids;//auctionID vs bidID
	Set<Integer> myAuctions;
	
	public User(String userName,int userID,String password,int type,EBAYSystem sys){
		this.userID=userID;
		this.userName=userName;
		this.password=password;
		this.sys=sys;
		this.activeBids=new HashMap<Integer,Integer>();
		this.myAuctions=new HashSet<Integer>();
	}
	
	public boolean placeBid(int auctionID,int amount){
		int bidId=this.sys.createBid(this,amount,auctionID);
		if(bidId==-1){
			return false;
		}
		this.activeBids.put(auctionID, bidId);
		return true;
	}
	
	public boolean createAuction(int expirationDate,int UPC,int startPrice){
		int id=this.sys.createAuctions(expirationDate,UPC,startPrice,this);
		if(id==-1){
			return false;
		}
		this.myAuctions.add(id);
		return true;
	}
	
	public boolean cancelAuction(int auctionID){
		if(!this.myAuctions.contains(auctionID)){
			return false;
		}
		if(this.sys.cancelAutction(auctionID)){
			this.myAuctions.remove(auctionID);
			return true;
		}
		return false;
	}
}

package design_TicketBooking;
import java.util.*;
/*
 * 订票服务，没有固定答案，分析需求（多种票，NBA,NFL），设计数据结构, 写算法
 */
public class BookingSystem {
	Map<String,TicketManager> ticketType;
	Map<TicketManager,Node> nodeMap;
	Map<String,TicketData> dataBase;
	Node head;
	Node tail;
	class Node{
		int count;
		Node previous;
		Node next;
		Set<TicketManager> set;
		public Node(int feq){
			this.count=feq;
			this.set=new HashSet<TicketManager>();
		}
	}
	public BookingSystem(){
		this.ticketType=new HashMap<String,TicketManager>();
		this.dataBase=new HashMap<String,TicketData>();
		this.nodeMap=new HashMap<TicketManager,Node>();
		this.head=new Node(0);
		this.tail=new Node(Integer.MAX_VALUE);
		head.next=tail;
		tail.previous=head;
	}
	public boolean addTicketType(String type,int r,int c,long time){
		if(this.ticketType.containsKey(type)){
			return false;
		}
		this.ticketType.put(type, new TicketManager(type));
		this.dataBase.put(type, new TicketData(type,time,r,c));
		this.nodeMap.put(this.ticketType.get(type),head);
		head.set.add(this.ticketType.get(type));
		return true;
	}
	public boolean checkTicketAvailablity(String type){
		if(!this.dataBase.containsKey(type)){
			return false;
		}
		
		return this.dataBase.get(type).available();
	}
	// can also return a ticket instead
	public boolean bookTicket(String type, int r,int c){
		boolean result=this.dataBase.get(type).bookSeat(r, c);
		if(result){
			addCount(type);
		}
		return result;
	}
	// can also take a ticket as input
	public boolean cancelTicket(String type, int r,int c){
		boolean result=this.dataBase.get(type).cancelSeat(r, c);
		if(result){
			reduceCount(type);
		}
		return result;
	}
	public void addCount(String type){
		TicketManager currManager=this.ticketType.get(type);
		currManager.countSold++;
		Node currNode=this.nodeMap.get(currManager);
		if(currNode.next.count==currNode.count+1){
			currNode.set.remove(currManager);
			currNode.next.set.add(currManager);
			nodeMap.put(currManager, currNode.next);
		}
		else{
			Node newNode=new Node(currManager.countSold);
			newNode.next=currNode.next;
			if(currNode.next!=null){
				currNode.next.previous=newNode;
			}
			currNode.next=newNode;
			newNode.previous=currNode;
			currNode.set.remove(currManager);
			newNode.set.add(currManager);
			nodeMap.put(currManager, newNode);
		}
		if(currNode.set.isEmpty()&&currNode!=head){
			currNode.previous.next=currNode.next;
			currNode.next.previous=currNode.previous;
		}
	}
	public void reduceCount(String type){
		TicketManager currManager=this.ticketType.get(type);
		currManager.countSold--;
		Node currNode=this.nodeMap.get(currManager);
		if(currNode.previous.count==currNode.count-1){
			currNode.set.remove(currManager);
			currNode.previous.set.add(currManager);
			nodeMap.put(currManager, currNode.previous);
		}
		else{
			Node newNode=new Node(currManager.countSold);
			newNode.previous=currNode.previous;
			if(currNode.previous!=null){
				currNode.previous.next=newNode;
			}
			newNode.next=currNode;
			currNode.previous=newNode;
			currNode.set.remove(currManager);
			newNode.set.add(currManager);
			nodeMap.put(currManager, newNode);
		}
		if(currNode.set.isEmpty()&&currNode!=tail){
			currNode.previous.next=currNode.next;
			currNode.next.previous=currNode.previous;
		}
	}
	
	public List<String> findMostPopular(int n){
		List<String> result=new ArrayList<String>();
		Node curr=tail;
		while(result.size()<n&&curr!=null){
			for(TicketManager tm:curr.set){
				result.add(tm.type);
			}
			curr=curr.previous;
		}
		return result;
	}
}

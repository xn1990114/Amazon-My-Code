package chatServer;

import java.util.*;

public class Chat {
	public int ID;
	public String name;
	Queue<Message> history;
	Set<Integer> participants;
	public Chat(int ID,String name){
		this.ID=ID;
		this.name=name;
		this.history=new LinkedList<Message>();
		this.participants=new HashSet<Integer>();
	}
	public boolean addUser(User u){
		if(this.participants.contains(u.ID)){
			return false;
		}
		this.participants.add(u.ID);
		return true;
	}
	public boolean removeUser(User u){
		if(this.participants.contains(u.ID)){
			this.participants.remove(u.ID);
			return true;
		}
		return false;
	}
	
	public boolean postMessage(Message m){
		if(!this.participants.contains(m.authorID)){
			return false;
		}
		if(this.history.size()==20){
			this.history.poll();
		}
		this.history.offer(m);
		return true;
	}
	
}

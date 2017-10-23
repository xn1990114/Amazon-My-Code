package design_chatServer;
import java.util.*;

public class User {
	public int ID;
	public String password;
	public Set<Integer> chats;
	
	public User(int ID,String password){
		this.ID=ID;
		this.password=password;
		this.chats=new HashSet<Integer>();
	}
	
	public boolean updatePassword(String oldpassword,String newPassword){
		if(this.password.equals(oldpassword)){
			this.password=newPassword;
			return true;
		}
		return false;
	}
	
	public boolean addChat(Chat c){
		if(c==null){
			return false;
		}
		if(this.chats.contains(c.ID)){
			return false;
		}
		if(!c.addUser(this)){
			return false;
		}
		this.chats.add(c.ID);
		return true;
	}
	
	public boolean quitChat(Chat c){
		if(c==null){
			return false;
		}
		if(!this.chats.contains(c.ID)){
			return false;
		}
		if(!c.removeUser(this)){
			return false;
		}
		this.chats.remove(c.ID);
		return true;
	}
	
	public Message createMessage(String content,int chatID){
		if(!this.chats.contains(chatID)){
			return null;
		}
		Message m=new Message(this.ID,chatID,content);
		return m;
	}
}

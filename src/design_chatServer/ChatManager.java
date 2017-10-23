package design_chatServer;
import java.util.*;

public class ChatManager {
	Map<Integer,Chat> chats;
	public ChatManager(){
		this.chats=new HashMap<Integer,Chat>();
	}
	
	public boolean createNewChat(int ID,String name){
		if(this.chats.keySet().contains(ID)){
			return false;
		}
		Chat newChat=new Chat(ID,name);
		this.chats.put(ID,newChat);
		return true;
	}
	public boolean removeChat(int ID){
		if(this.chats.keySet().contains(ID)){
			this.chats.remove(ID);
			return true;
		}
		return false;
	}
}

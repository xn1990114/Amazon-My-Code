package chatServer;
import java.util.*;

public class UserManager {
	Map<Integer,User> users;
	Set<Integer> onlineUsers;
	public UserManager(){
		this.users=new HashMap<Integer,User>();
		this.onlineUsers=new HashSet<Integer>();
	}
	
	public boolean signOn(int ID,String password){
		if(this.onlineUsers.contains(ID)){
			return false;
		}
		if(this.users.keySet().contains(ID)&&this.users.get(ID).password.equals(password)){
			this.onlineUsers.add(ID);
			return true;
		}
		return false;
	}
	
	public boolean signOff(int ID){
		if(this.onlineUsers.contains(ID)){
			this.onlineUsers.remove(ID);
			return true;
		}
		return false;
	}
	
	public void registerUser(int ID, String password){
		User newU=new User(ID,password);
		adduser(newU);
	}
	
	public boolean adduser(User u){
		if(u==null||this.users.keySet().contains(u.ID)){
			return false;
		}
		this.users.put(u.ID, u);
		return true;
	}
	
	public boolean removeUser(int userID){
		if(!this.users.keySet().contains(userID)){
			return false;
		}
		this.users.remove(userID);
		return true;
	}
	
}

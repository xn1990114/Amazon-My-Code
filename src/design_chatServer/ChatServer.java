package design_chatServer;

public class ChatServer {
	UserManager um;
	ChatManager cm;
	public ChatServer(){
		this.um=new UserManager();
		this.cm=new ChatManager();
	}
	
	public boolean createChat(int ID,String name){
		return this.cm.createNewChat(ID, name);
	}
	
	public boolean removeChat(int ID){
		return this.cm.removeChat(ID);
	}
	
	public void registerUser(int ID,String password){
		this.um.registerUser(ID, password);
	}
	public boolean removeUser(int ID){
		return this.um.removeUser(ID);
	}
	public boolean sendMessage(int userID,String content,int chatID){
		if(!this.um.onlineUsers.contains(userID)){
			return false;
		}
		if(!this.cm.chats.keySet().contains(chatID)||!this.cm.chats.get(chatID).participants.contains(userID)){
			return false;
		}
		Message m=this.um.users.get(userID).createMessage(content, chatID);
		return this.cm.chats.get(chatID).postMessage(m);
	}
	
	public boolean removeUserFromChat(int user,int chat){
		if(!this.cm.chats.keySet().contains(chat)){
			return false;
		}
		if(!this.um.onlineUsers.contains(user)){
			return false;
		}
		if(!this.cm.chats.get(chat).participants.contains(user)){
			return false;
		}
		Chat c=this.cm.chats.get(chat);
		this.um.users.get(user).quitChat(c);
		if(c.participants.size()<=1){
			for(int p:c.participants){
				this.um.users.get(p).quitChat(c);
			}
			this.cm.removeChat(chat);
		}
		
		return true;
	}
	public boolean addUserToChat(int user,int chat){
		if(!this.um.onlineUsers.contains(user)){
			return false;
		}
		if(!this.cm.chats.containsKey(chat)){
			return false;
		}
		return this.um.users.get(user).addChat(this.cm.chats.get(chat));
	}
	public boolean userSignOn(int ID,String password){
		return this.um.signOn(ID, password);
	}
	
	public boolean userSignOff(int ID){
		return this.um.signOff(ID);
	}
}

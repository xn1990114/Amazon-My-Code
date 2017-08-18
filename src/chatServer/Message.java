package chatServer;

public class Message {
	public static int time=0;
	public int authorID;
	public int targetChatID;
	public String content;
	public int timestamp;
	public Message(int authorID,int targetChatID,String content){
		this.authorID=authorID;
		this.targetChatID=targetChatID;
		this.content=content;
		this.timestamp=Message.time;
		Message.time++;
	}
}

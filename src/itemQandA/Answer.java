package itemQandA;

public class Answer {
	static int currID;
	int id;
	int posterID;
	long createdDate;
	String message;
	int questionID;
	public Answer(int posterID, long createdDate, String message, int questionID) {
		this.id = currID++;
		this.posterID = posterID;
		this.createdDate = createdDate;
		this.message = message;
		this.questionID = questionID;
	}
	public void editMessage(String newMessage){
		this.message=newMessage;
	}
	
}

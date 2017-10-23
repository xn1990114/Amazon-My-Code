package itemQandA;
import java.util.*;

public class Question {
	static int nextID;
	int id;
	List<Answer> answers;
	int posterID;
	String message;
	long createdDate;
	int itemID;
	
	public Question(int posterID, String message, long createdDate, int itemID) {
		this.id=nextID++;
		this.answers=new ArrayList<Answer>();
		this.posterID = posterID;
		this.message = message;
		this.createdDate = createdDate;
		this.itemID = itemID;
	}
	public boolean addAnswer(Answer a){
		if(a.questionID!=this.id){
			return false;
		}
		this.answers.add(a);
		return true;
	}
	public void removeAnswer(Answer a){
		this.answers.remove(a);
	}
	public void editMessage(String newMessage){
		this.message=newMessage;
	}
}

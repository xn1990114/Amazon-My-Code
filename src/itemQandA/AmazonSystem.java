package itemQandA;
import java.util.*;

public class AmazonSystem {
	Map<Integer,Item> items;
	Map<Integer,Question> questions;
	Map<Integer,Answer> answers;
	Map<Integer,User> users;
	public AmazonSystem(){
		this.items=new HashMap<Integer,Item>();
		this.questions=new HashMap<Integer,Question>();
		this.answers=new HashMap<Integer,Answer>();
	}
	public void addItem(String name){
		Item toadd=new Item(name);
		this.items.put(toadd.id, toadd);
	}
	public void addQuestion(int posterID, String message, long createdDate, int itemID){
		if(!this.users.containsKey(posterID)||!this.items.containsKey(itemID)){
			return;
		}
		Question toadd=new Question(posterID,message,createdDate,itemID);
		this.items.get(itemID).addQuestion(toadd);
	}
	public void removeQuestion(int qID){
		Question toremove=this.questions.get(qID);
		if(toremove==null){
			return;
		}
		this.items.get(toremove.itemID).removeQuestion(toremove);
	}
	public void addAnswer(int posterID, long createdDate, String message, int questionID){
		if(!this.users.containsKey(posterID)||!this.questions.containsKey(questionID)){
			return;
		}
		Answer toadd=new Answer(posterID,createdDate,message,questionID);
		this.questions.get(questionID).addAnswer(toadd);
	}
	public void removeAnswer(int aID){
		Answer toremove=this.answers.get(aID);
		if(toremove==null){
			return;
		}
		this.questions.get(toremove.questionID).removeAnswer(toremove);
	}
}

package itemQandA;
import java.util.*;

public class Item {
	static int nextID;
	int id;
	List<Question> questions;
	String name;
	public Item(String name) {
		this.id=nextID++;
		this.name = name;
		this.questions=new ArrayList<Question>();
	}
	public boolean addQuestion(Question q){
		if(q.itemID!=this.id){
			return false;
		}
		this.questions.add(q);
		return true;
	}
	public void removeQuestion(Question q){
		this.questions.remove(q);
	}
}

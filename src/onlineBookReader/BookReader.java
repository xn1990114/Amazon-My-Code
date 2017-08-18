package onlineBookReader;
import java.util.*;
// can furthuer break down to book manager and user manager
public class BookReader {
	User activeUser;
	Map<Integer,Book> bookList;
	Map<Integer,User> users;
	public BookReader(){
		this.bookList=new HashMap<Integer,Book>();
		this.users=new HashMap<Integer,User>();
	}
	public boolean addBook(Book b){
		if(b==null){
			return false;
		}
		this.bookList.put(b.ID, b);
		return true;
	}
	public boolean registerUser(int userID,String password){
		if(this.users.keySet().contains(userID)){
			return false;
		}
		this.users.put(userID, new User(userID,password));
		return true;
	}
	public boolean userSignin(int userID,String password){
		if(this.users.keySet().contains(userID)&&this.users.get(userID).password.equals(password)){
			if(this.activeUser!=null){
				this.activeUser.activeBookReader=null;
			}
			this.activeUser=this.users.get(userID);
			this.activeUser.activeBookReader=this;
			return true;
		}
		return false;
	}
	public boolean userSignOff(){
		if(this.activeUser==null){
			return false;
		}
		this.activeUser=null;
		return true;
	}
	public Book search(int BookID){
		return this.bookList.get(BookID);
	}
	public boolean readBook(int ID){
		Book b=search(ID);
		if(b==null){
			return false;
		}
		this.activeUser.readBook(b);
		return true;
	}
	public String nextPage(){
		return this.activeUser.nextPage();
	}
	
	public int getLastReadBook(){
		return this.activeUser.ActiveBookID;
	}
	public int getLastReadPage(){
		return this.activeUser.ActiveBookPage;
	}
}

package onlineBookReader;

public class User {
	public int userID;
	public String password;
	public int ActiveBookID;
	public int ActiveBookPage;
	public BookReader activeBookReader;
	public User(int userID,String password){
		this.userID=userID;
		this.password=password;
		this.ActiveBookID=0;
		this.ActiveBookPage=0;
	}
	public void readBook(Book b){
		this.ActiveBookID=b.ID;
		this.ActiveBookPage=0;
	}
	public String nextPage(){
		if(this.ActiveBookPage==-1){
			return null;
		}
		this.ActiveBookPage++;
		if(this.ActiveBookPage>this.activeBookReader.bookList.get(this.ActiveBookID).totalPage){
			this.ActiveBookPage=-1;
			return null;
		}
		return this.activeBookReader.bookList.get(this.ActiveBookID).displayPage(ActiveBookPage);
	}
}

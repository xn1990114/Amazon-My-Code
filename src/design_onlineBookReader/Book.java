package design_onlineBookReader;

public class Book {
	String name;
	String author;
	int ID;
	int totalPage;

	public Book(String name, String author, int ID, int totalPage) {
		this.name=name;
		this.author=author;
		this.ID=ID;
		this.totalPage=totalPage;
	}
	public String displayPage(int page){
		return this.name+page;
	}
}

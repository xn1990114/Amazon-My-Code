package jukeBox;

public class Song {
	private String name;
	private String singer;
	private int length;
	
	public Song(String name,String singer){
		this.name=name;
		this.singer=singer;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String newName){
		this.name=newName;
	}
	
	public String getSinger(){
		return this.singer;
	}
	
	public void play(){
		//do something
		System.out.println("Playing "+ this.name + " now");
	}
	public String toString(){
		return this.name+this.singer+this.length;
	}
}

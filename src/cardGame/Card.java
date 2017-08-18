package cardGame;

public class Card {
	public static int Spade=4;
	public static int Heart=3;
	public static int Diamond=2;
	public static int Club=1;
	
	public int color;
	public int num;
	public Card(int num,int color){
		this.num=num;
		this.color=color;
	}
}

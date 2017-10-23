package design_othello;

public class Piece {
	public final static boolean up=true;
	public final static boolean down=false;
	boolean position;
	int r;
	int c;
	public Piece(int row,int col,boolean pos){
		this.r=row;
		this.c=col;
		this.position=pos;
	}
	public void flip(){
		this.position=!this.position;
	}
}

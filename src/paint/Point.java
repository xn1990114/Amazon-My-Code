package paint;

public class Point {
	int x;
	int y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void move(int chgX,int chgY){
		this.x=this.x+chgX;
		this.y=this.y+chgY;
	}
}

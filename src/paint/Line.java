package paint;

public class Line implements Shape{
	Point start;
	Point end;
	public Line(int x1,int y1,int x2,int y2){
		this.start=new Point(x1,y1);
		this.end=new Point(x2,y2);
	}
	@Override
	public void move(int chgX,int chgY) {
		this.start.move(chgX, chgY);
		this.end.move(chgX, chgY);
	}
	@Override
	public void resize(int oriX,int oriY,int chgX,int chgY) {
		Point curr=this.start;
		Point oth=this.end;
		if(curr.x!=oriX||curr.y!=oriY){
			curr=this.end;
			oth=this.start;
		}
		curr.move(chgX, chgY);
		oth.move(-chgX, -chgY);
	}
}

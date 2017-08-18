package paint;

public class Rectangle implements Shape{
	Point topLeft;
	Point buttomRight;

	public Rectangle(int x1, int y1, int x2, int y2) {
		this.topLeft=new Point(Math.min(x1, x2),Math.min(y1, y2));
		this.buttomRight=new Point(Math.max(x1, x2),Math.max(y1, y2));
	}

	@Override
	public void move(int chgX, int chgY) {
		this.topLeft.move(chgX, chgY);
		this.buttomRight.move(chgX, chgY);
	}

	@Override
	public void resize(int oriX, int oriY, int chgX, int chgY) {
		if(this.topLeft.x==oriX){
			this.topLeft.move(chgX, 0);
		}
		if(this.topLeft.y==oriY){
			this.topLeft.move(0, chgY);
		}
		if(this.buttomRight.x==oriX){
			this.buttomRight.move(chgX, 0);
		}
		if(this.buttomRight.y==oriY){
			this.buttomRight.move(0,chgY);
		}
	}
}

package paint;

public class Circle implements Shape{
	Rectangle edge;
	public Circle(int x1, int y1, int x2, int y2) {
		this.edge=new Rectangle(x1,y1,x2,y2);
	}
	@Override
	public void move(int chgX, int chgY) {
		this.edge.move(chgX, chgY);
	}

	@Override
	public void resize(int oriX, int oriY, int chgX, int chgY) {
		this.edge.resize(oriX, oriY, chgX, chgY);
	}
	
}

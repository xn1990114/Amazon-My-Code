package design_paint;
/*
 * 设计有向图application. 用户可以创建 线,长方形,圆形,文本. 
 * manipulate them independently - move them, re-size them, etc. 
 * How would you model the representation of the document in an object oriented language? 
 * classes? methods? 这个会用到什么设计模式吗?
 */
public interface Shape {
	public void move(int chgX,int chgY);
	public void resize(int oriX,int oriY,int chgX,int chgY);
}

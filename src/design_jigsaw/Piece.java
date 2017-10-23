package design_jigsaw;

public class Piece {
	public int[] position;
	public int val;
	public Edge left;
	public Edge right;
	public Edge up;
	public Edge down;
	public Piece(int val,Edge l,Edge r,Edge u ,Edge d,int p1,int p2){
		this.val=val;
		this.left=l;
		this.right=r;
		this.up=u;
		this.down=d;
		this.position=new int[2];
		this.position[0]=p1;
		this.position[1]=p2;
	}
	public void rotate(){
		Edge temp=this.left;
		this.left=this.up;
		this.up=this.right;
		this.right=this.down;
		this.down=temp;
	}
	public String toString(){
		return this.position[0]+ " and "+ this.position[1];
	}
	/* cause issue in case of 3 outer boarder
	public boolean fit(Board b,int row,int col,int count){
		if(count==4){
			return false;
		}
		// up
		if(this.up==Edge.Flat){
			if(row-1>=0){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		else {
			if(row-1<0){
				this.rotate();
				return fit(b,row,col,count+1);
			}
			if(b.content[row-1][col]!=null&&this.up==b.content[row-1][col].down){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		//down
		if(this.down==Edge.Flat){
			if(row+1<b.content.length){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		else {
			if(row+1==b.content.length){
				this.rotate();
				return fit(b,row,col,count+1);
			}
			if(b.content[row+1][col]!=null&&this.down==b.content[row+1][col].up){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		//left
		if(this.left==Edge.Flat){
			if(col-1>=0){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		else {
			if(col-1<0){
				this.rotate();
				return fit(b,row,col,count+1);
			}
			if(b.content[row][col-1]!=null&&this.left==b.content[row][col-1].right){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		//right
		if(this.right==Edge.Flat){
			if(col+1<b.content[0].length){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		else {
			if(col+1==b.content[0].length){
				this.rotate();
				return fit(b,row,col,count+1);
			}
			if(b.content[row][col+1]!=null&&this.up==b.content[row][col+1].down){
				this.rotate();
				return fit(b,row,col,count+1);
			}
		}
		return true;
	}
	*/
	
}

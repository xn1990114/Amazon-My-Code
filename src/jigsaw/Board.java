package jigsaw;
import java.util.*;

public class Board {
	Piece[][] content;
	List<Piece> pieceList;
	public Board(int row,int col){
		this.content=new Piece[row][col];
		this.pieceList=new ArrayList<Piece>();
		createPieces(row,col);
	}
	public void createPieces(int row,int col){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				Piece p=new Piece(i*col+j,Edge.Flat,Edge.Flat,Edge.Flat,Edge.Flat,i,j);
				this.pieceList.add(p);
				this.content[i][j]=p;
			}
		}
	}
	public void startGame(){
		for(int i=0;i<this.content.length;i++){
			for(int j=0;j<this.content[0].length;j++){
				if(j+1<this.content[0].length){
					int setEdge=(int)(Math.random()*2);
					if(setEdge==0){
						content[i][j].right=Edge.Inner;
						if(j+1<this.content[0].length){
							content[i][j+1].left=Edge.Outer;
						}
					}
					else{
						content[i][j].right=Edge.Outer;
						if(j+1<this.content[0].length){
							content[i][j+1].left=Edge.Inner;
						}
					}
				}
				if(i+1<this.content.length){
					int setEdge=(int)(Math.random()*2);
					if(setEdge==0){
						content[i][j].down=Edge.Inner;
						if(i+1<this.content.length){
							content[i+1][j].up=Edge.Outer;
						}
					}
					else{
						content[i][j].down=Edge.Outer;
						if(i+1<this.content.length){
							content[i+1][j].up=Edge.Inner;
						}
					}
				}
			}
		}
		for(int i=0;i<this.content.length;i++){
			Arrays.fill(this.content[i],null);
		}
		for(int i=this.pieceList.size()-1;i>=0;i--){
			int index=(int)(Math.random()*(i+1));
			Piece p=this.pieceList.get(index);
			this.pieceList.set(index, this.pieceList.get(i));
			this.pieceList.set(i, p);
		}
		for(int i=0;i<this.pieceList.size();i++){
			int rotateCount=(int)(Math.random()*4);
			for(int j=0;j<rotateCount;j++){
				this.pieceList.get(i).rotate();
			}
		}
		System.out.println("Game is on");
	}
}

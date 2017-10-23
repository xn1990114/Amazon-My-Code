package design_Connect4Game;

public class Round {
	Cell[][] board;
	int activePlayerID;
	
	public Round(int height, int width, int activePlayerID) {
		this.board=new Cell[height][width];
		this.activePlayerID = activePlayerID;
	}
	
	public boolean placePiece(int r,int c){
		if(r+1<board.length&&this.board[r+1][c].occupliedPlayerID==0){
			return false;
		}
		if(!board[r][c].updateOccupiedPlayer(activePlayerID)){
			return false;
		}
		this.activePlayerID=3-this.activePlayerID;
		return true;
	}
	
	public int checkWinner(int r,int c){
		int id=this.board[r][c].occupliedPlayerID;
		if(id==0){
			return 0;
		}
		if(canWin(r,c,1,1)||canWin(r,c,-1,1)||canWin(r,c,1,0)||canWin(r,c,0,1)){
			return id;
		}
		return 0;
	}

	private boolean canWin(int r, int c, int i, int j) {
		int curr=this.board[r][c].occupliedPlayerID;
		int count=0;
		for(int pos=-3;pos<=3;pos++){
			int newR=r+i*pos;
			int newC=c+j*pos;
			if(newR<0||newR>=this.board.length||newC<0||newC>=this.board[0].length){
				continue;
			}
			if(this.board[newR][newC].occupliedPlayerID==curr){
				count++;
			}
		}
		return count>=4;
	}
}

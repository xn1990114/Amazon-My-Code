package design_othello;

import java.util.Arrays;

public class Game {
	Piece[][] board;
	Player[] players;
	int[] scores;
	int round;
	int turn;
	public Game(int len,Player p1,Player p2){
		this.board=new Piece[len][len];
		players=new Player[2];
		this.scores=new int[2];
		players[0]=p1;
		players[1]=p2;
		this.round=1;
	}
	
	public void start(){
		this.board[board.length/2-1][board.length/2-1]=new Piece(board.length/2-1,board.length/2-1,Piece.up);
		this.board[board.length/2][board.length/2]=new Piece(board.length/2,board.length/2,Piece.up);
		this.board[board.length/2-1][board.length/2]=new Piece(board.length/2-1,board.length/2,Piece.down);
		this.board[board.length/2][board.length/2-1]=new Piece(board.length/2,board.length/2-1,Piece.down);
		Arrays.fill(scores, 2);
	}
	public boolean putPiece(int r,int c){
		if(board[r][c]!=null){
			return false;
		}
		Piece p=new Piece(r,c,this.round%2==1);
		boolean canAdd=false;
		if(r-2>=0&&board[r-2][c].position==p.position&&board[r-1][c].position!=p.position){
			canAdd=true;
			board[r-1][c].flip();
			if(this.round%2==1){
				scores[0]++;
				scores[1]--;
			}
			else{
				scores[1]++;
				scores[0]--;
			}
		}
		if(r+2<board.length&&board[r+2][c].position==p.position&&board[r+1][c].position!=p.position){
			canAdd=true;
			board[r+1][c].flip();
			if(this.round%2==1){
				scores[0]++;
				scores[1]--;
			}
			else{
				scores[1]++;
				scores[0]--;
			}
		}
		if(c-2>=0&&board[r][c-2].position==p.position&&board[r][c-1].position!=p.position){
			canAdd=true;
			board[r][c-1].flip();
			if(this.round%2==1){
				scores[0]++;
				scores[1]--;
			}
			else{
				scores[1]++;
				scores[0]--;
			}
		}
		if(c+2<board[0].length&&board[r][c+2].position==p.position&&board[r][c+1].position!=p.position){
			canAdd=true;
			board[r][c+1].flip();
			if(this.round%2==1){
				scores[0]++;
				scores[1]--;
			}
			else{
				scores[1]++;
				scores[0]--;
			}
		}
		round++;
		if(canAdd){
			if(this.round%2==1){
				scores[0]++;
			}
			else{
				scores[1]++;
			}
		}
		return canAdd;
	}
	public boolean canPut(int r,int c){
		if(board[r][c]!=null){
			return false;
		}
		Piece p=new Piece(r,c,this.round%2==1);
		boolean canAdd=false;
		if(r-2>=0&&board[r-2][c].position==p.position&&board[r-1][c].position!=p.position){
			canAdd=true;
		}
		if(r+2<board.length&&board[r+2][c].position==p.position&&board[r+1][c].position!=p.position){
			canAdd=true;
		}
		if(c-2>=0&&board[r][c-2].position==p.position&&board[r][c-1].position!=p.position){
			canAdd=true;
		}
		if(c+2<board[0].length&&board[r][c+2].position==p.position&&board[r][c+1].position!=p.position){
			canAdd=true;
		}
		return canAdd;
	}
}

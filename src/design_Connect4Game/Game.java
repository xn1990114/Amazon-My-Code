package design_Connect4Game;
import java.util.*;

public class Game {
	Player[] players;
	List<Round> history;
	Round activeRound;
	public Game(String player1Name,String player2Name) {
		this.players=new Player[]{new Player(1,player1Name),new Player(2,player2Name)};
		this.history=new ArrayList<Round>();
		this.activeRound=null;
	}
	public void createRound(int height,int width){
		if(this.activeRound!=null){
			this.history.add(this.activeRound);
			this.activeRound=null;
		}
		this.activeRound=new Round(height,width,history.size()%2+1);
	}
	public boolean placePiece(int r,int c){
		if(this.activeRound==null){
			return false;
		}
		return this.activeRound.placePiece(r, c);
	}
	public int checkWinner(int r,int c){
		return this.activeRound.checkWinner(r, c);
	}
	public void updateScore(int playerID){
		this.players[playerID-1].addScore();
	}
}

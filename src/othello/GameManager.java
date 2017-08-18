package othello;
import java.util.*;

public class GameManager {
	Game currGame;
	Map<Integer,Player> players;
	
	public GameManager(){
		this.currGame=null;
		this.players=new HashMap<Integer,Player>();
	}
	public boolean startNewGame(int len,int p1ID,int p2ID){
		if(len<3||len%2==1||p1ID==p2ID){
			System.out.println("Invalid Input");
			return false;
		}
		if(!players.containsKey(p1ID)||!players.containsKey(p2ID)){
			System.out.println("User Not Found");
			return false;
		}
		this.currGame=new Game(len,players.get(p1ID),players.get(p2ID));
		return true;
	}
	public boolean putPiece(int r,int c){
		return currGame.putPiece(r, c);
	}
	public Player gameOver(){
		for(int i=0;i<this.currGame.board.length;i++){
			for(int j=0;j<this.currGame.board[0].length;j++){
				if(currGame.canPut(i, j)){
					System.out.println("Need More Moves");
					return null;
				}
			}
		}
		if(currGame.scores[0]>currGame.scores[1]){
			return currGame.players[0];
		}
		return currGame.players[1];
	}
}

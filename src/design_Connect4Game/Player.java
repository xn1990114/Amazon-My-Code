package design_Connect4Game;

public class Player {
	int id;
	int score;
	String playerName;
	public Player(int id, String playerName) {
		this.score=0;
		this.id = id;
		this.playerName = playerName;
	}
	public void addScore(){
		this.score++;
	}
}

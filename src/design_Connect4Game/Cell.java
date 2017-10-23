package design_Connect4Game;

public class Cell {
	int r;
	int c;
	int occupliedPlayerID;
	public Cell(int r,int c){
		this.r=r;
		this.c=c;
		this.occupliedPlayerID=0;
	}
	public boolean updateOccupiedPlayer(int playerID){
		if(this.occupliedPlayerID!=0){
			return false;
		}
		this.occupliedPlayerID=playerID;
		return true;
	}
}

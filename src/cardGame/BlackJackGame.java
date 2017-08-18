package cardGame;

import java.util.*;

public class BlackJackGame implements CardGame{
	List<BlackJackPlayer> players;
	Deck currDeck;
	int currRound;
	public BlackJackGame(){
		this.players=new ArrayList<BlackJackPlayer>();
		this.currDeck=null;
		this.currRound=0;
	}
	@Override
	public void prepareDeck(int playernum){
		if(playernum>10){
			return;
		}
		for(int i=0;i<playernum;i++){
			this.addPlayer(i);
		}
		this.currDeck=new Deck();
		this.currDeck.createDeck();
		this.currDeck.shuffleDeck();
	}
	
	public void startGame(){
		for(Player p:players){
			p.addCard(this.currDeck.drawCard());
			p.addCard(this.currDeck.drawCard());
		}
	}
	
	@Override
	public void drawCard(Player p) {
		Card c=this.currDeck.drawCard();
		if(c==null){
			return;
		}
		p.addCard(c);
	}
	
	@Override
	public List<Player> findWinner() {
		int maxpoint=-2;
		List<Player> winners=new ArrayList<Player>();
		for(Player p:players){
			if(maxpoint<p.calPoint()){
				winners.clear();
				winners.add(p);
				maxpoint=p.calPoint();
			}
			else if(maxpoint==p.calPoint()){
				winners.add(p);
			}
		}
		return winners;
	}
	
	@Override
	public void addPlayer(int ID) {
		BlackJackPlayer toadd=new BlackJackPlayer(ID);
		this.players.add(toadd);
	}
}

package design_cardGame;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	public List<Card> cards;
	public Deck(){
		this.cards=new ArrayList<Card>();
	}
	public void createDeck(){
		this.cards.clear();
		for(int i=1;i<=13;i++){
			for(int j=Card.Club;j<=Card.Spade;j++){
				this.cards.add(new Card(i,j));
			}
		}
	}
	public void shuffleDeck(){
		for(int i=this.cards.size()-1;i>=0;i--){
			int index=(int)(Math.random()*(i+1));
			Card temp=this.cards.get(index);
			this.cards.set(index, this.cards.get(i));
			this.cards.set(i, temp);
		}
	}
	public Card drawCard(){
		if(this.cards.isEmpty()){
			return null;
		}
		Card c=this.cards.get(this.cards.size()-1);
		this.cards.remove(this.cards.size()-1);
		return c;
	}
}

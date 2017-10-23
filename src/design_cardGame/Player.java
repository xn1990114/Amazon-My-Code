package design_cardGame;

import java.util.List;

public interface Player {
	int calPoint();
	void addCard(Card drawCard);
	public List<Card> getHand();
	public int getID();
}

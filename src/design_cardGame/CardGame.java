package design_cardGame;

import java.util.*;

public interface CardGame {
	public void prepareDeck(int playernum);
	public void drawCard(Player p);
	public List<Player> findWinner();
	public void addPlayer(int ID);
}

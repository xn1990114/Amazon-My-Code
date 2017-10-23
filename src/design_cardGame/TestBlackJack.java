package design_cardGame;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class TestBlackJack {

	@Test
	public void test() {
		BlackJackGame bjg=new BlackJackGame();
		bjg.prepareDeck(5);
		bjg.startGame();
		List<Player> winner=bjg.findWinner();
		for(Player p:bjg.players){
			for(Card c:p.getHand()){
				System.out.print(c.num+"\t");
			}
			System.out.println();
		}
		for(Player p:winner){
			System.out.println(p.getID());
		}
	}

}

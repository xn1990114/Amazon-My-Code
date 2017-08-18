package cardGame;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements Player{
		public int ID;
		public List<Card> hand;
		public BlackJackPlayer(int ID){
			this.ID=ID;
			this.hand=new ArrayList<Card>();
		}
		public void addCard(Card c){
			if(c==null){
				return;
			}
			this.hand.add(c);
		}
		public int calPoint(){
			int countA=0;
			int total=0;
			for(Card c:hand){
				if(c.num==1){
					total=total+11;
					countA++;
				}
				else if(c.num<10){
					total=total+c.num;
				}
				else{
					total=total+10;
				}
			}
			while(countA>0&&total>21){
				total=total-10;
				countA--;
			}
			return total>21?-1:total;
		}
		public int getID() {
			return ID;
		}
		public List<Card> getHand() {
			return hand;
		}

}

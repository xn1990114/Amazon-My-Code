package onsite;
import java.util.*;
/*
 * In a kingdom there are prison cells (numbered 1 to P) built to form a straight line segment. 
 * Cells number i and i+1 are adjacent, and prisoners in adjacent cells are called "neighbors." 
 * A wall with a window separates adjacent cells, and neighbors can communicate through that window.
 * All prisoners live in peace until a prisoner is released. 
 * When that happens, the released prisoner's neighbors find out, 
 * and each communicates this to his other neighbor. 
 * That prisoner passes it on to his other neighbor, 
 * and so on until they reach a prisoner with no other neighbor (because he is in cell 1, 
 * or in cell P, or the other adjacent cell is empty). 
 * A prisoner who discovers that another prisoner has been released will angrily break everything in his cell, 
 * unless he is bribed with a gold coin. So, after releasing a prisoner in cell A, 
 * all prisoners housed on either side of cell A - until cell 1, cell P or an empty cell - need to be bribed.
 * Assume that each prison cell is initially occupied by exactly one prisoner, 
 * and that only one prisoner can be released per day. 
 * Given the list of Q prisoners to be released in Q days, 
 * find the minimum total number of gold coins needed as bribes if the prisoners may be released in any order.
 * 
 * Input example:
 * 20 cells, 3 prisoners to be released: 3, 6 and 14
 * |1|2| |4|5| |7|8|9|10|11|12|13| |15|16|17|18|19|20|
 * release prisoner 3: 19 gold coins
 * release prisoner 6: 16 gold coins
 * release prisoner 14: 13 gold coins
 * 
 * release 14: 19 gold coins
 * release 6: 12 gold coins
 * release 3: 4 gold coins
 * 
 * 
 */
public class PrisonCellProblem {
	public int findMinCost(int N,Set<Integer> toBeReleased){
		int count=0;
		int[] cells=new int[N];
		for(int i=0;i<cells.length;i++){
			cells[i]=i;
		}
		Queue<int[]> qu=new LinkedList<int[]>();
		int[] first={0,N-1};
		qu.offer(first);
		while(!toBeReleased.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				int[] top=qu.poll();
				int mid=searchMiddle(top,toBeReleased);
				if(mid>=0){
					count=count+top[1]-top[0];
					if(mid>top[0]){
						int[] toadd={top[0],mid-1};
						qu.offer(toadd);
					}
					if(mid<top[1]){
						int[] toadd={mid+1,top[1]};
						qu.offer(toadd);
					}
				}
			}
		}
		return count;
	}
	public int searchMiddle(int[] range,Set<Integer> toBeReleased){
		int mid=range[0]+(range[1]-range[0])/2;
		int dif=0;
		while(mid+dif<=range[1]||mid-dif>=range[0]){
			int up=mid+dif;
			if(toBeReleased.contains(up)){
				toBeReleased.remove(up);
				return up;
			}
			int down=mid-dif;
			if(down<range[0]){
				break;
			}
			if(toBeReleased.contains(down)){
				toBeReleased.remove(down);
				return down;
			}
			dif++;
		}
		return -1;
	}
}

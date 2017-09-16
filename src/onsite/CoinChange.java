package onsite;

import java.util.Arrays;

/*
 * 然后是money 找change， change有四类，0.01,0.05,0.25, 0.1, 
 * 刚开始我还让面试官一个一个给我把coin的名字写出来，我说我没用过coin， 然后这题是从高往下走，比如说0.52,
先把最大的找出来，然后是次大的，0.52先是两个0.25,然后是两个0.01. 
follow up是如果再加上其它币种怎么办，楼主说的是设计一个interface，有一个方法是public Map<> Change(), 
每一个币种，比如说欧元是一个class，美元是一个class，然后implement interface，实现自己的币种，或者把自己的币种换算成美元.
 */
public class CoinChange {
	public String findCoinsChange(double[] coins,double change){
		StringBuilder sb=new StringBuilder();
		Arrays.sort(coins);
		int index=coins.length-1;
		while(change>0.009){
			if(change>coins[index]-0.001){
				sb.append("+");
				sb.append(coins[index]);
				change=change-coins[index];
			}
			else{
				index--;
			}
		}
		if(change>0.009||sb.length()==0){
			return "impossible";
		}
		return sb.toString();
	}
}

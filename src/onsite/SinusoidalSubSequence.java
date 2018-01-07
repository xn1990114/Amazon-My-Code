package onsite;

import java.util.Arrays;

/*
 * Given a string, find the longest sinusoidal sequence in it. 
 * If there are multiple such sequences of same maximum length, 
 * return the one which comes first in lexicographic order in a dictionary..
 * Sinusoidal means increasing then decreasing then increasing and so on.
Example ::
a r u n ::
aun,arn,run are three such sequencesoflength3....But, 
arn is output since it comes first in lexicographic order.
Interviewer gave me hints that if I had to found the sequence in which all elements were increasing, 
then I answered LIS will give me the solution , this was the hint. 
So, basically, it was a variation of LIS. I answered it in O(n2) and 2n space....
Then was asked to do it in (n) space and o(n).
 */
public class SinusoidalSubSequence {
	public String pathSubSequence(String s){
		if(s.length()<=1){
			return s;
		}
		// 0- next index, 1- total length if move up from next char; 2- total len if move down
		int[][] next=new int[s.length()][256];
		//0- char used for increasing 1- max len if increase
		//2- char used for decreasing 3- max len if decrease
		int[][] lens=new int[s.length()][4];
		lens[s.length()-1][0]=' ';
		lens[s.length()-1][1]=1;
		lens[s.length()-1][2]=' ';
		lens[s.length()-1][3]=1;
		for(int i=0;i<s.length();i++){
			Arrays.fill(next[i], -1);
		}
		for(int i=s.length()-2;i>=0;i--){
			for(int j=0;j<256;j++){
				next[i][j]=next[i+1][j];
			}
			next[i][s.charAt(i+1)]=i+1;
		}
		for(int i=s.length()-2;i>=0;i--){
			char currChar=s.charAt(i);
			char upChar=' ';
			char downChar=' ';
			int upLen=1;
			int downLen=1;
			for(int j=0;j<256;j++){
				if(next[i][j]!=-1){
					int index=next[i][j];
					if(currChar<j){
						if(lens[index][3]+1>upLen){
							upLen=lens[index][3]+1;
							upChar=(char)j;
						}
					}
					else if(currChar>j){
						if(lens[index][1]+1>downLen){
							downLen=lens[index][1]+1;
							downChar=(char)j;
						}
					}
				}
			}
			lens[i][0]=upChar;
			lens[i][1]=upLen;
			lens[i][2]=downChar;
			lens[i][3]=downLen;
		}
		int startPoint=0;
		for(int i=0;i<s.length();i++){
			if(lens[startPoint][1]<lens[i][1]||(lens[startPoint][1]==lens[i][1]&&s.charAt(i)<s.charAt(startPoint))){
				startPoint=i;
			}
		}
		StringBuilder sb=new StringBuilder();
		boolean up=true;
		while(startPoint>=0){
			sb.append(s.charAt(startPoint));
			if(up){
				startPoint=next[startPoint][lens[startPoint][0]];
			}
			else{
				startPoint=next[startPoint][lens[startPoint][2]];
			}
			up=!up;
		}
		return sb.toString();
	}
}

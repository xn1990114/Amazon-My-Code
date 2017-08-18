package onsite;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
 */
public class HighestBoxStack {
	class Box implements Comparable<Box>{
		int[] dm;
		public Box(int l,int w,int h){
			dm=new int[]{l,w,h};
		}
		@Override
		public int compareTo(Box b){
			int curr=this.dm[0]*this.dm[1];
			int bArea=b.dm[0]*b.dm[1];
			return curr-bArea;
		}
	}
	public int findHight(int[] length,int[] width,int[] height){
		List<Box> list=new ArrayList<Box>();
		for(int i=0;i<length.length;i++){
			Box b1=new Box(length[i],width[i],height[i]);
			Box b2=new Box(width[i],height[i],length[i]);
			Box b3=new Box(height[i],length[i],width[i]);
			list.add(b1);
			list.add(b2);
			list.add(b3);
		}
		Collections.sort(list);
		int max=0;
		int[] h=new int[list.size()];
		for(int i=0;i<list.size();i++){
			Box curr=list.get(i);
			h[i]=curr.dm[2];
			for(int j=i-1;j>=0;j--){
				Box pre=list.get(j);
				if((pre.dm[0]<curr.dm[0]&&pre.dm[1]<curr.dm[1])||(pre.dm[1]<curr.dm[0]&&pre.dm[0]<curr.dm[1])){
					h[i]=Math.max(h[i], h[j]+curr.dm[2]);
				}
			}
			max=Math.max(max, h[i]);
		}
		return max;
	}
}

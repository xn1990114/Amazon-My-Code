package phone;
import java.util.*;
/*
 * Given N sorted arrays, get median number.
 */
public class MedianOfNArray {
	public double findMedian(List<List<Integer>> list){
		int size=0;
		TreeSet<int[]> ts=new TreeSet<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		int count=0;
		for(int i=0;i<list.size();i++){
			size=size+list.get(i).size();
			if(list.get(i).size()>0){
				int[] toadd={0,list.get(i).size()-1,list.get(i).get((list.get(i).size()-1)/2),i};
				ts.add(toadd);
				count=count+((list.get(i).size()-1)/2)+1;
			}
		}
		double l=findKth(ts,list,(size+1)/2,count);
		if(size%2==1){
			return l;
		}
		size=0;
		ts.clear();
		count=0;
		for(int i=0;i<list.size();i++){
			size=size+list.get(i).size();
			if(list.get(i).size()>0){
				int[] toadd={0,list.get(i).size()-1,list.get(i).get((list.get(i).size()-1)/2),i};
				ts.add(toadd);
				count=count+((list.get(i).size()-1)/2)+1;
			}
		}
		double r=findKth(ts,list,(size+1)/2+1,count);
		return (l+r)/2.0;
	}
	public double findKth(TreeSet<int[]> ts,List<List<Integer>> list,int k,int count){
		while(!ts.isEmpty()){
			int[] low=ts.first();
			int[] high=ts.last();
			if(low==high){
				if(count==k){
					return low[2];
				}
			}
			if(count<=k){
				ts.remove(low);
				int mid=low[0]+(low[1]-low[0])/2;
				low[0]=mid+1;
				int newMid=low[0]+(low[1]-low[0])/2;
				if(low[0]>low[1]){
					continue;
				}
				low[2]=list.get(low[3]).get(newMid);
				count=count+(newMid-mid);
				ts.add(low);
			}
			else{
				ts.remove(high);
				int mid=high[0]+(high[1]-high[0])/2;
				high[1]=mid-1;
				if(high[1]<high[0]){
					count--;
					continue;
				}
				int newMid=high[0]+(high[1]-high[0])/2;
				high[2]=list.get(high[3]).get(newMid);
				count=count-(mid-newMid);
				ts.add(high);
			}
		}
		return -100;
	}
}

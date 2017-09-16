package onsite;

import java.util.Arrays;
import java.util.*;

//一堆horizontal的线段，找出vertical的最多重叠的range”题的升级版
public class MostOverlappedInterval {
	public class Interval implements Comparable<Interval>{
		int start;
		int end;
		public Interval(int start,int end){
			this.start=start;
			this.end=end;
		}
		public int compareTo(Interval i2){
			return this.start-i2.start;
		}
	}
	public String findMostOverlappedInterval(Interval[] intervals){
		if(intervals.length==0){
			return "Empty input";
		}
		int maxCount=0;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		PriorityQueue<Interval> pq=new PriorityQueue<Interval>(new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end-o2.end;
			}
			
		});
		Arrays.sort(intervals);
		int i=0;
		while(i<intervals.length){
			while(i<intervals.length&&(pq.isEmpty()||intervals[i].start<pq.peek().end)){
				pq.offer(intervals[i]);
				i++;
			}
			if(pq.size()>maxCount){
				maxCount=pq.size();
				map.clear();
				map.put(intervals[i-1].start, pq.peek().end);
			}
			else if(pq.size()==maxCount){
				map.put(intervals[i-1].start, pq.peek().end);
			}
			pq.poll();
		}
		StringBuilder sb=new StringBuilder();
		sb.append(("maxCount is: "+maxCount+"\n"));
		sb.append(("results are: "+"\n"));
		for(int s:map.keySet()){
			sb.append("{"+s+","+map.get(s)+"}");
		}
		return sb.toString();
	}
}

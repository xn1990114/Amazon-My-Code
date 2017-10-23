package onsite;
import java.util.*;
/*
 * find most frequent user activity. 输入是一个log file记录每个用户看页面跳转的顺序。
 * user1 看了pageA -> pageB -> pageC -> pageD -> pageE -> pageF. 
 * user2 看了 pageA -> pageB -> pageC -> pageD. 
 * user3 看了 pageA -> pageB -> pageC -> pageD. 
 * 则返回pageA -> pageB -> pageC 和 pageB -> pageC -> pageD. 这里限定了找最常出现的长度为3的跳转记录。
 */
public class MostPopularBrowsingSequence {
	public List<String> findMostPopular(String[][] his){
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		List<String> res=new ArrayList<String>();
		int max=0;
		for(int i=0;i<his.length;i++){
			String[] curr=his[i];
			for(int j=0;j<curr.length-2;j++){
				String toadd=curr[j]+"->"+curr[j+1]+"->"+curr[j+2];
				if(!map.containsKey(toadd)){
					map.put(toadd, 0);
				}
				map.put(toadd,map.get(toadd)+1);
			}
		}
		for(String key:map.keySet()){
			if(map.get(key)>max){
				res.clear();
				max=map.get(key);
				res.add(key);
			}
			else if(map.get(key)==max){
				res.add(key);
			}
		}
		return res;
	}
}

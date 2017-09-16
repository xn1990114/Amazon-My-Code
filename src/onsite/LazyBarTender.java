package onsite;
import java.util.*;
/*
 * Lazy Bartender

There are N number of possible drinks
Has C number of fixed customers
Every customer has fixed favourite set of drinks
Bartender has to create least possible number of drinks
to suffice need of all the customers
Example
Cust1:n3,n7,n5,n2,n9
Cust2:n5
Cust3:n2,n3
Cust4:n4
Cust5:n3,n4,n3,n5,n7,n4

Output:3(n3,n4,n5)
 */
public class LazyBarTender {
	public int countDrinks(List<List<String>> req){
		Map<String,Set<Integer>> map=new HashMap<String,Set<Integer>>();
		for(int i=0;i<req.size();i++){
			List<String> curr=req.get(i);
			for(String d:curr){
				if(!map.containsKey(d)){
					map.put(d, new HashSet<Integer>());
				}
				map.get(d).add(i);
			}
		}
		int count=0;
		while(!map.isEmpty()){
			int max=-1;
			String maxDrink="";
			for(String key:map.keySet()){
				if(map.get(key).size()>max){
					max=map.get(key).size();
					maxDrink=key;
				}
			}
			Set<Integer> toremove=map.get(maxDrink);
			Set<String> notNeeded=new HashSet<String>();
			map.remove(maxDrink);
			count++;
			for(String key:map.keySet()){
				map.get(key).removeAll(toremove);
				if(map.get(key).size()==0){
					notNeeded.add(key);
				}
			}
			for(String key:notNeeded){
				map.remove(key);
			}
		}
		return count;
	}
}

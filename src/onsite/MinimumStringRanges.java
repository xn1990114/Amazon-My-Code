package onsite;
import java.util.*;
/*
 * s="Hello! today is Monday, tomorrow is Tuesday, yesterday is Sunday. 
 * today and tomorrow are sunny.", keywords = {"is", "today", "tomorrow"}, 
 * output: [1, 4] 代表“today is Monday, tomorrow”;  
 * 如果keywords={"today", "tomorrow"},output:[10,12]代表“today and tomorrow”.
 */
public class MinimumStringRanges {
	public int findMinStringLen(String s,String[] keyWords){
		if(s==null||s.length()==0){
			return -1;
		}
		List<String> strs=makeList(s);
		
		Map<String,Integer> target=new HashMap<String,Integer>();
		Map<String,Integer> source=new HashMap<String,Integer>();
		for(String key:keyWords){
			if(!target.containsKey(key)){
				target.put(key,0);
			}
			target.put(key, target.get(key)+1);
		}
		int start=0;
		int matched=0;
		int res=Integer.MAX_VALUE;
		for(int end=0;end<strs.size();end++){
			String curr=strs.get(end);
			if(target.containsKey(curr)){
				if(!source.containsKey(curr)){
					source.put(curr, 0);
				}
				source.put(curr, source.get(curr)+1);
				if(source.get(curr).equals(target.get(curr))){
					matched++;
				}
				while(matched==target.keySet().size()){
					res=Math.min(res, end-start+1);
					String firstStr=strs.get(start);
					start++;
					if(!target.containsKey(firstStr)){
						continue;
					}
					if(source.get(firstStr).equals(target.get(firstStr))){
						matched--;
					}
					source.put(firstStr, source.get(firstStr)-1);
				}
			}
		}
		return res==Integer.MAX_VALUE?-1:res;
	}
	public List<String> makeList(String s){
		List<String> strs=new ArrayList<String>();
		int index=0;
		while(index<s.length()){
			char ch=s.charAt(index);
			if(Character.isLetter(ch)){
				int start=index;
				while(index<s.length()&&Character.isLetter(s.charAt(index))){
					index++;
				}
				strs.add(s.substring(start,index).toLowerCase());
			}
			else{
				index++;
			}
		}
		return strs;
	}
}

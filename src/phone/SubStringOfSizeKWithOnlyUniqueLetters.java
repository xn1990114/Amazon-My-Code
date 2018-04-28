package phone;
import java.util.*;
//给一个字符串s，窗口size=k，找出所有长度为k并且字符不重复的子串
public class SubStringOfSizeKWithOnlyUniqueLetters {
	public List<String> findSubstringWithUniqueLetter(String s,int k){
		List<String> res=new ArrayList<String>();
		int start=0;
		int countUnique=0;
		int[] count=new int[256];
		for(int end=0;end<s.length();end++){
			char ch=s.charAt(end);
			if(count[ch]==1){
				countUnique--;
			}
			count[ch]++;
			if(count[ch]==1){
				countUnique++;
			}
			if(end-start+1==k){
				if(countUnique==k){
					res.add(s.substring(start,end+1));
				}
				char ch2=s.charAt(start);
				if(count[ch2]==1){
					countUnique--;
				}
				count[ch2]--;
				if(count[ch2]==1){
					countUnique++;
				}
				start++;
			}
		}
		return res;
	}
	public boolean sameResult(List<String> r1,String[] r2){
		if(r1.size()!=r2.length){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			if(!r1.get(i).equals(r2[i])){
				return false;
			}
		}
		return true;
	}
}

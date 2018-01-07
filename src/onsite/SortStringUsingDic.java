package onsite;
import java.util.*;

public class SortStringUsingDic {
	@SuppressWarnings("hiding")
	public class MyComparator<Character> implements Comparator<Character>{
		Map<Character,Integer> map;
		public MyComparator(Map<Character,Integer> map){
			this.map=map;
		}
		public int compare(Character ch1,Character ch2){
			if(map.containsKey(ch1)&&map.containsKey(ch2)){
				return map.get(ch1)-map.get(ch2);
			}
			else if(map.containsKey(ch1)){
				return -1;
			}
			else if(map.containsKey(ch2)){
				return 1;
			}
			return (int)((char)ch1-(char)ch2);
		}
	}
	public String sortStringWithComparator(String s,String dic){
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<dic.length();i++){
			map.put(dic.charAt(i), i);
		}
		Character[] array=new Character[s.length()];
		for(int i=0;i<s.length();i++){
			array[i]=s.charAt(i);
		}
		Arrays.sort(array,new MyComparator<Character>(map));
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			sb.append(array[i]);
		}
		return sb.toString();
	}
	public String sortStringWithOutComparator(String s,String dic){
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<dic.length();i++){
			map.put(dic.charAt(i), i);
		}
		int[] inDic=new int[256];
		int[] noDic=new int[256];
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(map.containsKey(ch)){
				inDic[map.get(ch)]++;
			}
			else{
				noDic[ch]++;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<256;i++){
			for(int j=0;j<inDic[i];j++){
				sb.append(dic.charAt(i));
			}
		}
		for(int i=0;i<256;i++){
			for(int j=0;j<noDic[i];j++){
				sb.append((char)i);
			}
		}
		return sb.toString();
	}
}

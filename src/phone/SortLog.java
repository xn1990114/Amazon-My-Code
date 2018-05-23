package phone;
import java.util.*;
/*
 * 就是给你一个log file， 让你根据每一行的第二个string来进行排序，然后只排含字母的，（
 * 如果含有数字的话全都放在bottom，顺序按照原顺序不变）
 */
public class SortLog {
	class logComparator implements Comparator<String[]>{
		public int compare(String[] log1,String[] log2){
			return log1[1].compareTo(log2[1]);
		}
	}
	public List<String> sort(List<String> logs){
		List<String[]> noDigit=new ArrayList<String[]>();
		List<String> hasDigit=new ArrayList<String>();
		for(int i=0;i<logs.size();i++){
			String s=logs.get(i);
			if(hasDigit(s)){
				hasDigit.add(s);
			}
			else{
				int index=s.indexOf(' ');
				String[] log={s.substring(0, index),s.substring(index+1)};
				noDigit.add(log);
			}
		}
		Collections.sort(noDigit,new logComparator());
		List<String> res=new ArrayList<String>();
		for(int i=0;i<noDigit.size();i++){
			String[] toadd=noDigit.get(i);
			res.add(toadd[0]+" "+toadd[1]);
		}
		res.addAll(hasDigit);
		return res;
	}
	public boolean hasDigit(String s){
		int index=s.indexOf(' ');
		for(int i=index;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				return true;
			}
		}
		return false;
	}
}

package onsite;
import java.util.*;
/*
 * 判断两个date是否less than one month。
 * Jul 6,2017 format
 */
public class DateDistance {
	public boolean withinOneMonth(String d1,String d2){
		long[] a1=decode(d1);
		long[] a2=decode(d2);
		int[] dic={360,30,1};
		long n1=0;
		long n2=0;
		for(int i=0;i<3;i++){
			n1=n1+a1[i]*dic[i];
			n2=n2+a2[i]*dic[i];
		}
		return Math.abs(n1-n2)<=30;
	}
	public long[] decode(String s){
		Map<String,Long> map=new HashMap<String,Long>();
		map.put("Jan", 1L);map.put("Feb", 2L);map.put("Mar", 3L);map.put("Apr", 4L);
		map.put("May", 5L);map.put("Jun", 6L);map.put("Jul", 7L);map.put("Aug", 8L);
		map.put("Sep", 9L);map.put("Oct", 10L);map.put("Nov", 11L);map.put("Dec", 12L);
		long[] res=new long[3];
		int start=0;
		for(int i=0;i<=s.length();i++){
			if(i==s.length()){
				res[0]=Long.parseLong(s.substring(start,i));
				start=i+1;
			}
			else if(s.charAt(i)==' '){
				res[1]=map.get(s.substring(start,i));
				start=i+1;
			}
			else if(s.charAt(i)==','){
				res[2]=Long.parseLong(s.substring(start,i));
				start=i+1;
			}
		}
		return res;
	}
}

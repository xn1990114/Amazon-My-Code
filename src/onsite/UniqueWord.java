package onsite;
import java.util.*;
/*
 * N个lists，每个list由不同单词构成，用O(N)的空间找出N个lists中，只出现过一次的单词。
 */
public class UniqueWord {
	class Element implements Comparable<Element>{
		String s;
		int row;
		int col;
		public Element(String s,int row){
			this.s=s;
			this.row=row;
			this.col=0;
		}
		public int compareTo(Element e2){
			return this.s.compareTo(e2.s);
		}
	}
	public String findUnique(List<List<String>> strs){
		String last=null;
		boolean alone=false;
		PriorityQueue<Element> pq=new PriorityQueue<Element>();
		for(int i=0;i<strs.size();i++){
			bubbleSort(strs.get(i));
			if(strs.get(i).size()>0){
				Element e=new Element(strs.get(i).get(0),i);
				pq.offer(e);
			}
		}
		while(!pq.isEmpty()){
			Element top=pq.poll();
			if(last==null||!top.s.equals(last)){
				if(alone){
					return last;
				}
				else{
					last=top.s;
					alone=true;
				}
			}
			else{
				alone=false;
			}
			top.col++;
			if(top.col<strs.get(top.row).size()){
				top.s=strs.get(top.row).get(top.col);
				pq.offer(top);
			}
		}
		if(alone){
			return last;
		}
		return null;
	}
	public void bubbleSort(List<String> list){
		for(int i=list.size()-1;i>0;i--){
			for(int j=1;j<=i;j++){
				if(list.get(j-1).compareTo(list.get(j))>0){
					String s=list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, s);
				}
			}
		}
	}
}

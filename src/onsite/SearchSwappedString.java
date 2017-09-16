package onsite;
import java.util.*;
/*
 * 亚麻的bar raiser 题，似曾相识 发上来集思广益一下
输入是一个字典和一个string input，
要求 string input只能swap两个字母，
判断是否能生成合法字符出现在字典里，然后输出生成的合法数量
 */
public class SearchSwappedString {
	class TrieNode{
		Map<Character,TrieNode> child;
		String s;
		public TrieNode(){
			this.child=new HashMap<Character,TrieNode>();
		}
	}
	public void buildTrie(TrieNode root,String s){
		TrieNode curr=root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(!curr.child.containsKey(ch)){
				curr.child.put(ch, new TrieNode());
			}
			curr=curr.child.get(ch);
		}
		curr.s=s;
	}
	// lv 0- no swap, lv 1- replaced first letter but original letter was not placed
	// lv 2- swapped 2 letters.
	public void search(TrieNode curr,int level,int index,String s,List<String> res,char need,char ori,Set<String> dic){
		for(int i=index;i<s.length();i++){
			char ch=s.charAt(i);
			if(level==0){
				for(char key:curr.child.keySet()){
					search(curr.child.get(key),1,i+1,s,res,key,ch,dic);
				}
			}
			else if(level==1){
				if(curr.child.containsKey(ori)&&ch==need){
					search(curr.child.get(ori),2,i+1,s,res,need,ori,dic);
				}
			}
			if(!curr.child.containsKey(ch)){
				return;
			}
			curr=curr.child.get(ch);
		}
		if(level==2&&curr.s!=null&&dic.contains(curr.s)){
			dic.remove(curr.s);
			res.add(curr.s);
		}
	}
	public List<String> findString(Set<String> dic,String target){
		List<String> res=new ArrayList<String>();
		TrieNode root=new TrieNode();
		for(String s:dic){
			buildTrie(root,s);
		}
		search(root,0,0,target,res,' ',' ',dic);
		return res;
	}
	public void dislayList(List<String> list){
		if(list.size()==0){
			System.out.println("empty list");
			return;
		}
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+",");
		}
		System.out.println();
	}
	public List<String> findStringBS(Set<String> dic,String target){
		List<String> res=new ArrayList<String>();
		for(int i=0;i<target.length();i++){
			for(int j=i+1;j<target.length();j++){
				String temp=target.substring(0,i)+target.charAt(j)+target.substring(i+1,j)+target.charAt(i)+target.substring(j+1);
				if(dic.contains(temp)){
					//dic.remove(temp);
					res.add(temp);
				}
			}
		}
		return res;
	}
}

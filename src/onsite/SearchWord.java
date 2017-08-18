package onsite;
import java.util.*;
/*
 * 给一个纯数字的string以及一个字典，用电话上九宫格的那个打字方法打出数字的string，
 * 这样就会有很多个单词，哪些是在给定的字典里面的。
 * 我的做法是先根据字典做一个preffix set，就是字典中每个单词的前缀。
 * 然后对给定的数字string循环，每一次循环结束只保留存在在preffix set中的组合。然后问了我时间复杂度和优化，
 * 我说用trie tree优化，然后让我写了trie tree。
 */
public class SearchWord {
	class Node{
		Node[] child;
		String s;
		public Node(){
			this.child=new Node[256];
		}
	}
	public void buildTrie(Node root,String s){
		Node curr=root;
		for(int i=0;i<s.length();i++){
			int ch=s.charAt(i);
			if(curr.child[ch]==null){
				curr.child[ch]=new Node();
			}
			curr=curr.child[ch];
		}
		curr.s=s;
	}
	public void search(String input,int index,List<String> result,Node curr,Set<Character>[] map){
		if(index==input.length()){
			if(curr.s!=null){
				result.add(curr.s);
			}
			return;
		}
		int ch=input.charAt(index)-'0';
		for(char c:map[ch]){
			if(curr.child[c]!=null){
				search(input,index+1,result,curr.child[c],map);
			}
		}
	}
	public List<String> findWords(String input,Set<String> dic){
		@SuppressWarnings("unchecked")
		Set<Character>[] map=new Set[10];
		for(int i=0;i<10;i++){
			map[i]=new HashSet<Character>();
		}
		map[0].add(' ');map[2].add('a');map[2].add('b');map[2].add('c');
		map[3].add('d');map[3].add('e');map[3].add('f');
		map[4].add('g');map[4].add('h');map[4].add('i');
		map[5].add('j');map[5].add('k');map[5].add('l');
		map[6].add('m');map[6].add('n');map[6].add('o');
		map[7].add('p');map[7].add('q');map[7].add('r');map[7].add('s');
		map[8].add('t');map[8].add('u');map[8].add('v');
		map[9].add('w');map[9].add('x');map[9].add('y');map[9].add('z');
		Node root=new Node();
		for(String s:dic){
			buildTrie(root,s);
		}
		List<String> result=new ArrayList<String>();
		search(input,0,result,root,map);
		return result;
	}
}

package onsite;
import java.util.*;
//given 2d character matrix , print out all paths which equals to a given string.
public class WordSearchPath {
	public List<List<int[]>> searchWordPath(char[][] board,String target){
		List<List<int[]>> res=new ArrayList<List<int[]>>();
		if(board==null||board.length==0||board[0].length==0||target==null||target.length()==0){
			return res;
		}
		List<int[]> currPath=new ArrayList<int[]>();
		boolean[][] visited=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				dfs(currPath,res,i,j,board,visited,target,0);
			}
		}
		return res;
	}
	public void dfs(List<int[]> currPath,List<List<int[]>> res,int r,int c,char[][] board,boolean[][] visited,String target,int index){
		if(index==target.length()||visited[r][c]||board[r][c]!=target.charAt(index)){
			return;
		}
		currPath.add(new int[]{r,c});
		index++;
		visited[r][c]=true;
		if(index==target.length()){
			res.add(new ArrayList<int[]>(currPath));
		}
		else{
			if(r-1>=0&&!visited[r-1][c]){
				dfs(currPath,res,r-1,c,board,visited,target,index);
			}
			if(r+1<board.length&&!visited[r+1][c]){
				dfs(currPath,res,r+1,c,board,visited,target,index);
			}
			if(c-1>=0&&!visited[r][c-1]){
				dfs(currPath,res,r,c-1,board,visited,target,index);
			}
			if(c+1<board[0].length&&!visited[r][c+1]){
				dfs(currPath,res,r,c+1,board,visited,target,index);
			}
		}
		visited[r][c]=false;
		currPath.remove(currPath.size()-1);
	}
	public void printPath(List<List<int[]>> res){
		for(int i=0;i<res.size();i++){
			List<int[]> curr=res.get(i);
			for(int j=0;j<curr.size();j++){
				if(j!=0){
					System.out.print("->");
				}
				int[] a=curr.get(j);
				System.out.print("["+a[0]+","+a[1]+"]");
			}
			System.out.println();
		}
	}
}

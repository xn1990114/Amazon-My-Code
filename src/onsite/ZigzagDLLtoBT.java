package onsite;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a dl representing the spiral level order traversal of a binary tree,
 * convert it to a binary tree inplace. 
 * In Last level, nodes will be either to the right or left only.
eg 1-2-3-4-5-6-7-8
o/p--
		1
		/\
	   3   2 
	  /\   /\
     4  5  6  7 
     		   \
     		   	8
 */
public class ZigzagDLLtoBT {
	public class Node{
		public Node left;
		public Node right;
		public int val;
		public Node(int val){
			this.val=val;
		}
	}
	public Node convertToBT(Node root){
		if(root==null){
			return root;
		}
		Node parent=root;
		int level=1;
		while(parent!=null){
			int count=(1<<level);
			Node start=parent.right;
			if(start!=null) start.left=null;
			Node end=parent.right;
			for(int i=0;i<count-1&&end!=null&&end.right!=null;i++){
				end=end.right;
			}
			int c=0;
			while(parent!=null&&c<count){
				Node nextP=parent.left;
				if(level%2==1){
					parent.right=start;
					start=start==null?null:start.right;
					parent.left=start;
					start=start==null?null:start.right;
				}
				else{
					parent.left=start;
					start=start==null?null:start.right;
					parent.right=start;
					start=start==null?null:start.right;
				}
				parent=nextP;
				c=c+2;
			}
			level++;
			parent=end;
		}
		return root;
	}
	public void displayTree(Node root){
		Queue<Node> qu=new LinkedList<Node>();
		qu.offer(root);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				Node top=qu.poll();
				if(top!=null){
					System.out.print(top.val+"  ");
					qu.offer(top.left);
					qu.offer(top.right);
				}
				else{
					System.out.print("null  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}

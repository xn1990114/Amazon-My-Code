package onsite;
import java.util.*;
/*
 * 两颗结构不同的树，中序遍历是否相等（同时非递归遍历两棵树的节点，一个一个比较），follow up 优化代码
 */
public class SameInorderTreeChecker {
	public class Node{
		public int val;
		public Node left;
		public Node right;
		public Node(int val){
			this.val=val;
		}
	}
	public boolean checkSame(Node root1,Node root2){
		if(root1==null&&root2==null){
			return true;
		}
		if(root1==null||root2==null){
			return false;
		}
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		Node curr1=root1;
		Node curr2=root2;
		while(curr1!=null||curr2!=null){
			if(curr1!=null){
				s1.push(curr1);
				curr1=curr1.left;
			}
			if(curr2!=null){
				s2.push(curr2);
				curr2=curr2.left;
			}
		}
		while(!s1.isEmpty()&&!s2.isEmpty()){
			Node t1=s1.pop();
			Node t2=s2.pop();
			if(t1.val!=t2.val){
				return false;
			}
			if(t1.right!=null){
				t1=t1.right;
				while(t1!=null){
					s1.push(t1);
					t1=t1.left;
				}
			}
			if(t2.right!=null){
				t2=t2.right;
				while(t2!=null){
					s2.push(t2);
					t2=t2.left;
				}
			}
		}
		return s1.isEmpty()&&s2.isEmpty();
	}
}

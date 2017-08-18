package onsite;

public class BSTtoDLL {
	public class Node{
		int val;
		Node previous;
		Node next;
		public Node(int val){
			this.val=val;
		}
	}
	public class TreeNode{
		int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public Node convert(TreeNode root){
		Node[] result=buildList(root);
		return result[0];
	}
	
	public Node[] buildList(TreeNode curr){
		Node[] result=new Node[2];
		if(curr==null){
			return result;
		}
		Node currNode=new Node(curr.val);
		Node[] left=buildList(curr.left);
		Node[] right=buildList(curr.right);
		currNode.previous=left[1];
		if(left[1]!=null){
			left[1].next=currNode;
		}
		currNode.next=right[0];
		if(right[0]!=null){
			right[0].previous=currNode;
		}
		result[0]=left[0]==null?currNode:left[0];
		result[1]=right[1]==null?currNode:right[1];
		return result;
		
	}
	public void display(Node head){
		Node curr=head;
		while(curr!=null){
			System.out.print(curr.val+" ");
			curr=curr.next;
		}
	}
}

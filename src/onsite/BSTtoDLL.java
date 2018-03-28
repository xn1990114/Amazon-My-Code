package onsite;

import java.util.Stack;
// approach 2 is better
public class BSTtoDLL {
	public class Node {
		int val;
		Node previous;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// method 1 iteration - morris
	public TreeNode convertToDDLUsingMorris(TreeNode root) {
		if(root==null){
			return null;
		}
		TreeNode head=root;
		TreeNode last=null;
		while(head.left!=null){
			head=head.left;
		}
		TreeNode curr=root;
		while(curr!=null){
			if(curr.left==null){
				last=curr;
				curr=curr.right;
			}
			else{
				TreeNode l=curr.left;
				if(last!=null){
					last.right=l;
				}
				while(l.right!=null){
					l=l.right;
				}
				l.right=curr;
				l=curr.left;
				curr.left=null;
				curr=l;
			}
		}
		curr=head;
		last=null;
		while(curr!=null){
			curr.left=last;
			last=curr;
			curr=curr.right;
		}
		return head;
	}

	// method 2 iteration - stack
	public TreeNode convertToDDLUsingStack(TreeNode root) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode head=null;
		TreeNode last=null;
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
		while(!stack.isEmpty()){
			TreeNode top=stack.pop();
			TreeNode right=top.right;
			top.left=null;
			top.right=null;
			while(right!=null){
				stack.push(right);
				right=right.left;
			}
			if(last==null){
				head=top;
			}
			else{
				last.right=top;
				top.left=last;
			}
			last=top;
		}
		return head;
	}

	// method 3 recursion
	public Node convert(TreeNode root) {
		Node[] result = buildList(root);
		return result[0];
	}

	public Node[] buildList(TreeNode curr) {
		Node[] result = new Node[2];
		if (curr == null) {
			return result;
		}
		Node currNode = new Node(curr.val);
		Node[] left = buildList(curr.left);
		Node[] right = buildList(curr.right);
		currNode.previous = left[1];
		if (left[1] != null) {
			left[1].next = currNode;
		}
		currNode.next = right[0];
		if (right[0] != null) {
			right[0].previous = currNode;
		}
		result[0] = left[0] == null ? currNode : left[0];
		result[1] = right[1] == null ? currNode : right[1];
		return result;

	}

	public void display(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}

	public void display(TreeNode head) {
		TreeNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.right;
		}
	}
}

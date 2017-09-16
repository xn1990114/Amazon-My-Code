package onsite;
/*
 * Given any two nodes in a binary tree, find the path from 1st node to another, 
 * and tell if the path is a straight line, or there are turns on the line, find number of turns.
 */
public class TreeNodeStraightPath {
	public class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public class Element{
		int foundCount;
		int countTurns;
		char lastTurn;
		public Element(int foundCount,int countTurns){
			this.foundCount=foundCount;
			this.countTurns=countTurns;
			this.lastTurn=' ';
		}
	}
	public int countTurns(TreeNode root,TreeNode n1,TreeNode n2){
		if(n1==n2){
			return 0;
		}
		return findPath(root,n1,n2).countTurns;
	}
	public Element findPath(TreeNode curr,TreeNode n1,TreeNode n2){
		if(curr==null){
			return new Element(0,0);
		}
		Element left=findPath(curr.left,n1,n2);
		Element right=findPath(curr.right,n1,n2);
		if(left.foundCount==3){
			return left;
		}
		if(right.foundCount==3){
			return right;
		}
		if(curr==n1||curr==n2){
			if(left.foundCount>0){
				left.foundCount=3;
				if(left.lastTurn=='r'){
					left.countTurns++;
				}
				left.lastTurn='l';
				return left;
			}
			else if(right.foundCount>0){
				right.foundCount=3;
				if(right.lastTurn=='l'){
					right.countTurns++;
				}
				right.lastTurn='r';
				return right;
			}
			else{
				return new Element(curr==n1?1:2,0);
			}
		}
		else{
			if(left.foundCount+right.foundCount==3){
				if(left.lastTurn=='r'){
					left.countTurns++;
				}
				if(right.lastTurn=='l'){
					right.countTurns++;
				}
				return new Element(3,left.countTurns+right.countTurns+1);
			}
			else if(left.foundCount>0){
				if(left.lastTurn=='r'){
					left.countTurns++;
				}
				left.lastTurn='l';
				return left;
			}
			else if(right.foundCount>0){
				if(right.lastTurn=='l'){
					right.countTurns++;
				}
				right.lastTurn='r';
				return right;
			}
		}
		return new Element(0,0);
	}
}

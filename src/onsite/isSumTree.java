package onsite;


//http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
public class isSumTree {
	public class TreeNode{
		int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public class Data{
		int sum;
		boolean isSumTree;
		public Data(){
			this.sum=0;
			this.isSumTree=false;
		}
	}
	public boolean isValid(TreeNode root){
		return cal(root).isSumTree;
	}
	public Data cal(TreeNode curr){
		Data res=new Data();
		if(curr==null){
			res.isSumTree=true;
			return res;
		}
		if(curr.left==null&&curr.right==null){
			res.sum=curr.val;
			res.isSumTree=true;
			return res;
		}
		Data dl=cal(curr.left);
		Data dr=cal(curr.right);
		res.sum=curr.val+dr.sum+dl.sum;
		res.isSumTree=dl.isSumTree&&dr.isSumTree&&(dl.sum+dr.sum==curr.val);
		return res;
	}
}

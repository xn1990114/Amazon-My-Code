package onsite;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 给两个array A和B，两个array的元素都一样，只是顺 序不一样，要求用stack处理A，
 * 允许的操作有push和pop，让stack pop出来的数字正好可以组成B ，如果不能实现返回空。
 * elements are unqiue
 */
public class ReArrangeElementWithStack {
	public List<Integer> rearrange(int[] ori,int[] target){
		List<Integer> res=new ArrayList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		int index1=0;
		int index2=0;
		while(index2<target.length){
			if(stack.isEmpty()||stack.peek()!=target[index2]){
				if(index1==ori.length){
					break;
				}
				stack.push(ori[index1]);
				index1++;
			}
			else{
				index2++;
				res.add(stack.pop());
			}
		}
		if(index2==target.length){
			return res;
		}
		return new ArrayList<Integer>();
	}
	public boolean sameRes(List<Integer> res,int[] target){
		if(res.size()!=target.length){
			return false;
		}
		for(int i=0;i<target.length;i++){
			if(target[i]!=res.get(i)){
				return false;
			}
		}
		return true;
	}
}

package onsite;

import java.util.Stack;

/*
 * 给两个array A和B，两个array的元素都一样，只是顺序不一样，
 * 要求用stack处理A，允许的操作有push和pop，让stack pop出来的数字正好可以组成B，如果不能实现返回空。
 */
/*
 * [1,2,3,4,5]
 * [5,2,4,1,3]
 */
public class DuplicateArray {
	public int[] makeBStack(int[] A,int[] B){
		if(A==null||B==null||A.length!=B.length){
			return null;
		}
		Stack<Integer> stack=new Stack<Integer>();
		int[] result=new int[B.length];
		int index=0;
		int i=0;
		int j=0;
		while(i<A.length&&j<B.length){
			if(A[i]==B[j]){
				stack.push(A[i]);
				result[index]=stack.pop();
				index++;
				j++;
				i++;
			}
			else if(!stack.isEmpty()&&stack.peek()==B[j]){
				result[index]=stack.pop();
				index++;
				j++;
			}
			else{
				stack.push(A[i]);
				i++;
			}
		}
		while(!stack.isEmpty()){
			if(stack.peek()==B[j]){
				result[index]=stack.pop();
				j++;
				index++;
			}
			else{
				break;
			}
		}
		if(index!=B.length){
			return null;
		}
		return result;
	}
}

package onsite;
import java.util.*;
/*
 * Given an array of integers A and an integer k, 
 * find a subarray that contains the largest sum, 
 * subject to a constraint that the sum is less than k.
 */
public class SubArrayLessThanK {
	public int findMax(int[] nums,int k){
		TreeSet<Integer> pre=new TreeSet<Integer>();
		pre.add(0);
		int sum=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			sum=sum+nums[i];
			// sum-pre<=k-1 pre>=sum-k+1
			Integer min=pre.ceiling(sum-k+1);
			if(min!=null){
				max=Math.max(max, sum-min);
			}
			pre.add(sum);
		}
		return max;
	}
}

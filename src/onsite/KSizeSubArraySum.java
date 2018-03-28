package onsite;
import java.util.*;
/*
 * Given an integer array and an integer target. 
 * Ask all the subarray of size k sums up to the target
 */
public class KSizeSubArraySum {
	// return start index
	public List<Integer> findSubArrayOfK(int[] nums,int k,int target){
		int start=0;
		List<Integer> res=new ArrayList<Integer>();
		int sum=0;
		for(int end=0;end<nums.length;end++){
			sum=sum+nums[end];
			if(end-start+1==k){
				if(sum==target){
					res.add(start);
				}
				sum=sum-nums[start];
				start++;
			}
		}
		return res;
	}
	public boolean checkResult(List<Integer> r1,int[] r2){
		if(r1.size()!=r2.length){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			if(r1.get(i)!=r2[i]){
				return false;
			}
		}
		return true;
	}
}

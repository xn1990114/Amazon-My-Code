package onsite;
/*
 * You are given an unsorted binary array.
 * Ex [0 1 1 0 0 1 0 1 1 1 1 0 0 1 0 0 1]
 * and a number K, which represents the number of swap operations allowed on this binary array.
 * you need to find out the maximum length continuous subarray that can be generated using K many swaps.
 * Ex if K = 3 in above case
 * [0 1 1 0 0 1 0 1 1 1 1 0 0 1 0 0 1] => [0 1 1 0 0 1 1 1 1 1 1 0 0 0 0 0 1] 
 * => [0 1 1 0 1 1 1 1 1 1 1 0 0 0 0 0 0] => [0 0 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0]
 */
public class LongestContinuousOneBySwap {
	public int countMax(int[] nums,int k){
		int maxLen=0;
		int maxPossible=0;
		int usedSwap=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==1){
				maxPossible++;
			}
		}
		int start=0;
		for(int end=0;end<nums.length;end++){
			if(nums[end]==0){
				usedSwap++;
				while(usedSwap>k){
					if(nums[start]==0){
						usedSwap--;
					}
					start++;
				}
			}
			if(end-start+1>maxPossible){
				if(nums[start]==0){
					usedSwap--;
				}
				start++;
			}
			maxLen=Math.max(maxLen, end-start+1);
		}
		return maxLen;
	}
}

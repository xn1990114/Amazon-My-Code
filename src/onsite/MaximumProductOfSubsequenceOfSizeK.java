package onsite;

import java.util.Arrays;
//http://www.geeksforgeeks.org/maximum-product-subsequence-size-k/

public class MaximumProductOfSubsequenceOfSizeK {
	public int findMax(int[] nums,int k){
		if(k>nums.length){
			return 0;
		}
		int temp=1;
		Arrays.sort(nums);
		for(int i=nums.length-1;i>=nums.length-k;i--){
			temp=temp*nums[i];
		}
		int max=temp;
		temp=1;
		for(int i=0;i<k;i++){
			temp=temp*nums[i];
		}
		max=Math.max(max, temp);
		temp=1;
		int start=0;
		int end=nums.length-1;
		int count=0;
		while(count<(k%2==1?k-1:k)){
			if(nums[start]*nums[start+1]>nums[end]*nums[end-1]){
				temp=temp*nums[start]*nums[start+1];
				start=start+2;
			}
			else{
				temp=temp*nums[end]*nums[end-1];
				end=end-2;
			}
			count=count+2;
		}
		if(k%2==1){
			temp=Math.max(temp*nums[start], temp*nums[end]);
		}
		max=Math.max(temp, max);
		return max;
	}
}

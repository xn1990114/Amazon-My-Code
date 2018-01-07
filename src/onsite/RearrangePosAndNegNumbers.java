package onsite;

/*
 * Given an array containing both positive and negative elements, 
 * arrange in such a manner — 1 positive number, then 1 negative,then 1 positive and so on. 
 * If number of negative numbers are more,extra numbers should be kept in end and vice versa.
 * Note the order of negative and positive elements should be same in the modified 
 * array and you are not allowed to use any extra space
 */
public class RearrangePosAndNegNumbers {
	public void rearrangeArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0 && nums[i] < 0) {
				int j = i + 1;
				while (j < nums.length && nums[j] < 0) {
					j++;
				}
				if(j==nums.length){
					break;
				}
				int target = nums[j];
				for (int k = j; k > i; k--) {
					nums[k] = nums[k - 1];
				}
				nums[i] = target;
			} else if (i % 2 == 1 && nums[i] > 0) {
				int j = i + 1;
				while (j < nums.length && nums[j] > 0) {
					j++;
				}
				if(j==nums.length){
					break;
				}
				int target = nums[j];
				for (int k = j; k > i; k--) {
					nums[k] = nums[k - 1];
				}
				nums[i] = target;
			}
		}
		
	}
	public void rearrangeArrayNoOrders(int[] nums){
		int count=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				count++;
			}
			else{
				count--;
			}
		}
		if(count!=0){
			if(count>0){
				int i1=nums.length-1;
				int i2=nums.length-1;
				while(i2>=0&&nums.length-1-i1<count){
					while(i2>=0&&nums[i2]<0){
						i2--;
					}
					if(i2>=0){
						int temp=nums[i1];
						nums[i1]=nums[i2];
						nums[i2]=temp;
						i2--;
						i1--;
					}
				}
			}
			else{
				count=-count;
				int i1=nums.length-1;
				int i2=nums.length-1;
				while(i2>=0&&nums.length-1-i1<count){
					while(i2>=0&&nums[i2]>0){
						i2--;
					}
					if(i2>=0){
						int temp=nums[i1];
						nums[i1]=nums[i2];
						nums[i2]=temp;
						i1--;
						i2--;
					}
				}
			}
		}
		int start=0;
		int end=nums.length-count-1;
		while(start<nums.length&&end>=0){
			while(start<nums.length&&nums[start]>0){
				start=start+2;
			}
			while(end>=0&&nums[end]<0){
				end=end-2;
			}
			if(start<nums.length&&end>=0){
				int temp=nums[start];
				nums[start]=nums[end];
				nums[end]=temp;
				start=start+2;
				end=end-2;
			}
		}
	}
}

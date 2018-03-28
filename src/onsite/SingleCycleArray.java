package onsite;
/*
 * Given an array of integers where each element points to the index increment,  
 * the (index + value) is the next index in the array.
 * how would you detect if it is a single complete cycle in this array?
比如 [1, 3]    1 at index 0 -- > 1+0 = 1
Index 1, value = 3--->  1+3 = 4 然后转到了 index 0
说明从index 0 遍历所有元素后又回到了index 0，则return true

比如 [1,2] 1 at index 0 --> 1+0 = 1
index 1, value 2 ---> 1+2 = 3 所以 回到了index 1
说明有一个circle，但没有回到起始位置，则return false
 */
public class SingleCycleArray {
	public boolean isSingleCycleArray(int[] nums){
		if(nums==null||nums.length==0){
			return false;
		}
		boolean[] visited=new boolean[nums.length];
		int curr=0;
		while(!visited[curr]){
			visited[curr]=true;
			curr=(curr+nums[curr])%nums.length;
		}
		if(curr!=0){
			return false;
		}
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				return false;
			}
		}
		return true;
	}
}

package onsite;
import java.util.*;
/*
 * 大致是给一个array，和一个size： int k, 然后重新处理array，
 * 输出时每一个位置上是当前部分array第k个distinct element, 每遇到一个之前遇到的element就删掉，比如
 * input: [3, 5, 7, 8, 2, 5, 4, 2] k = 3
 * output: [ null, null, 7, 7, 7, 8, 8, 8]
 */
public class UniqueValueArray {
	public Integer[] findUniqueArray(int[] nums,int k){
		Integer[] res=new Integer[nums.length];
		Set<Integer> lower=new HashSet<Integer>();
		Set<Integer> higher=new LinkedHashSet<Integer>();
		Set<Integer> duplicated=new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			if(!duplicated.contains(nums[i])){
				if(lower.contains(nums[i])||higher.contains(nums[i])){
					lower.remove(nums[i]);
					higher.remove(nums[i]);
					duplicated.add(nums[i]);
					if(lower.size()<k-1&&higher.size()>0){
						int next=higher.iterator().next();
						lower.add(next);
						higher.remove(next);
					}
				}
				else{
					if(lower.size()<k-1){
						lower.add(nums[i]);
					}
					else{
						higher.add(nums[i]);
					}
				}
			}
			if(higher.size()>0){
				res[i]=higher.iterator().next();
			}
		}
		return res;
	}
	public boolean match(Integer[] i1,Integer[] i2){
		if(i1.length!=i2.length){
			return false;
		}
		for(int i=0;i<i1.length;i++){
			if(i1[i]!=i2[i]){
				return false;
			}
		}
		return true;
	}
}

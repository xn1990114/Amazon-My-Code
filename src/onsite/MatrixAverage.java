package onsite;
/*
 * 问的是类似image smoother 的题（要求2d数组内每一个点变成周围3*3的平均值 ），
 * 一开始我想了一个能完美解决 上下左右四个方向的in place解法 但是他叫我先写brutal force。。
 * 于是15分钟左右写完然后他再叫我写了之前的in place的优化
 * {{1,1,1,1,1,1}
 *  {2,2,2,2,2,2}
 *  {3,3,3,3,3,3}
 *  {4,4,4,4,4,4}
 *  {5,5,5,5,5,5}
 * }
 */
public class MatrixAverage {
	public void replaceToAverage(double[][] nums){
		if(nums==null||nums.length==0||nums[0].length==0){
			return;
		}
		for(int i=0;i<nums.length;i++){
			double last=0;
			double newLast=0;
			for(int j=0;j<nums[i].length;j++){
				newLast=nums[i][j];
				double dd=nums[i][j]+(j==0?0:last)+(j==nums[i].length-1?0:nums[i][j+1]);
				double dv=1+(j==0?0:1)+(j==nums[i].length-1?0:1);
				nums[i][j]=dd/dv;
				last=newLast;
			}
		}
		for(int j=0;j<nums[0].length;j++){
			double last=0;
			double newLast=0;
			for(int i=0;i<nums.length;i++){
				newLast=nums[i][j];
				double dd=nums[i][j]+(i==0?0:last)+(i==nums.length-1?0:nums[i+1][j]);
				double dv=1+(i==0?0:1)+(i==nums.length-1?0:1);
				nums[i][j]=dd/dv;
				last=newLast;
			}
		}
	}
	public void display(double[][] nums){
		for(int i=0;i<nums.length;i++){
			for(int j=0;j<nums[i].length;j++){
				System.out.print(nums[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}

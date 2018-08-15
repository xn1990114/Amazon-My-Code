package phone;
import java.util.*;
/*
 * 找出所有 组合使得 a^2+b^2+c^2+d^2 = k， k是input .
 */

// missing detail, assuming a,b,c,d can only be >=0 and duplicate is allowed.
// for result, duplicate is not allowed.
// assuming no overflow
public class FourSquareSum {
	public List<int[]> find4SquareSum(int k){
		List<int[]> res=new ArrayList<int[]>();
		if(k<0){
			return res;
		}
		int max=(int)Math.sqrt(k);
		for(int a=0;a<=max;a++){
			for(int b=a;b<=max;b++){
				for(int c=b;c<=max;c++){
					int total=a*a+b*b+c*c;
					int left=k-total;
					int d=(int)Math.sqrt(left);
					if(d<c){
						break;
					}
					if(d>=c&&d*d==left){
						res.add(new int[]{a,b,c,d});
					}
				}
			}
		}
		return res;
	}
	public void printResult(List<int[]> res){
		for(int[] array:res){
			System.out.println(array[0]+"-"+array[1]+"-"+array[2]+"-"+array[3]);
		}
		System.out.println();
	}
}

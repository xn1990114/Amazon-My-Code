package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MaximumProductOfSubsequenceOfSizeK;

public class MaximumProductOfSubsequenceOfSizeKTester {

	@Test
	public void test() {
		MaximumProductOfSubsequenceOfSizeK tester=new MaximumProductOfSubsequenceOfSizeK();
		int[] nums1={1, 2, 0, 3};
		int k1=2;
		assertTrue(tester.findMax(nums1, k1)==6);
		int[] nums2={1, 2, -1, -3, -6, 4};
		int k2=4;
		assertTrue(tester.findMax(nums2, k2)==144);
		int[] nums3={-10,-6,-5,-4,-3,1,9,10};
		int k3=4;
		assertTrue(tester.findMax(nums3, k3)==5400);
		int[] nums4={-5,-4,-3,1,9,10};
		int k4=4;
		assertTrue(tester.findMax(nums4, k4)==1800);
		int[] nums5={-5,-4,-3,-1,-1};
		int k5=5;
		assertTrue(tester.findMax(nums5, k5)==-60);
		int[] nums6={-10,-8,-7,-6,-5,-4,-3,-1,-1};
		int k6=5;
		assertTrue(tester.findMax(nums6, k6)==-60);
		int[] nums7={-10,-8,-7,-6,-5,-4,-3,-1,-1,0};
		int k7=5;
		assertTrue(tester.findMax(nums7, k7)==0);
		int[] nums8={-10,-8,-7,-6,-5,-4,-3,-1,0};
		int k8=4;
		assertTrue(tester.findMax(nums8, k8)==3360);
	}

}

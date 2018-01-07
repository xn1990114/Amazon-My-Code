package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RearrangePosAndNegNumbers;

public class RearrangePosAndNegNumbersTester {

	@Test
	public void test() {
		RearrangePosAndNegNumbers tester=new RearrangePosAndNegNumbers();
		int[] nums1={-5,1,-2,1,4,1,-5,2};
		int[] nums2={-5,1,-2,1,4,1,-5,2};
		int[] nums3={1,-2,-5,2};
		int[] nums4={1,2,5,2};
		int[] res1={1,-5,1,-2,4,-5,1,2};
		int[] res2={1,-2,1,-5,4,-5,1,2};
		int[] res3={1,-2,2,-5};
		int[] res4={1,2,5,2};
		tester.rearrangeArray(nums1);
		for(int i=0;i<nums1.length;i++){
			assertTrue(nums1[i]==res1[i]);
		}
		tester.rearrangeArrayNoOrders(nums2);
		for(int i=0;i<nums2.length;i++){
			assertTrue(nums2[i]==res2[i]);
		}
		tester.rearrangeArrayNoOrders(nums3);
		for(int i=0;i<nums3.length;i++){
			assertTrue(nums3[i]==res3[i]);
		}
		tester.rearrangeArrayNoOrders(nums4);
		for(int i=0;i<nums4.length;i++){
			assertTrue(nums4[i]==res4[i]);
		}
	}

}

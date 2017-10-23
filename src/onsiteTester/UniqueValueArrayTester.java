package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.UniqueValueArray;

public class UniqueValueArrayTester {

	@Test
	public void test() {
		int[] nums1={3, 5, 7, 8, 2, 5, 4, 2};
		int k1=3;
		Integer[] r1={null, null, 7, 7, 7, 8, 8, 8};
		int[] nums2={3, 5, 7, 8, 2, 3, 4, 2};
		int k2=3;
		Integer[] r2={null, null, 7, 7, 7, 8, 8, 8};
		int[] nums3={3, 5, 7, 8, 2, 2, 4, 2};
		int k3=3;
		Integer[] r3={null, null, 7, 7, 7, 7, 7, 7};
		int[] nums4={3, 5, 7, 8, 2, 2, 4, 2};
		int k4=3;
		Integer[] r4={null, null, 7, 7, 7, 7, 7, 7};
		int[] nums5={3, 3, 8, 8, 2, 2, 4, 2};
		int k5=1;
		Integer[] r5={3, null, 8, null, 2, null, 4, 4};
		UniqueValueArray tester=new UniqueValueArray();
		assertTrue(tester.match(tester.findUniqueArray(nums1, k1), r1));
		assertTrue(tester.match(tester.findUniqueArray(nums2, k2), r2));
		assertTrue(tester.match(tester.findUniqueArray(nums3, k3), r3));
		assertTrue(tester.match(tester.findUniqueArray(nums4, k4), r4));
		assertTrue(tester.match(tester.findUniqueArray(nums5, k5), r5));
	}

}

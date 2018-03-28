package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.KSizeSubArraySum;

public class KSizeSubArraySumTester {

	@Test
	public void test1() {
		KSizeSubArraySum tester=new KSizeSubArraySum();
		int[] nums={1,2,3,4};
		int k=5;
		int target=0;
		int[] res={};
		assertTrue(tester.checkResult(tester.findSubArrayOfK(nums, k, target), res));
	}
	@Test
	public void test2() {
		KSizeSubArraySum tester=new KSizeSubArraySum();
		int[] nums={1,2,3,4};
		int k=2;
		int target=3;
		int[] res={0};
		assertTrue(tester.checkResult(tester.findSubArrayOfK(nums, k, target), res));
	}
	@Test
	public void test3() {
		KSizeSubArraySum tester=new KSizeSubArraySum();
		int[] nums={1,2,3,4,3,2,1};
		int k=4;
		int target=10;
		int[] res={0,3};
		assertTrue(tester.checkResult(tester.findSubArrayOfK(nums, k, target), res));
	}
	@Test
	public void test4() {
		KSizeSubArraySum tester=new KSizeSubArraySum();
		int[] nums={1,2,3};
		int k=5;
		int target=0;
		int[] res={};
		assertTrue(tester.checkResult(tester.findSubArrayOfK(nums, k, target), res));
	}
	@Test
	public void test6() {
		KSizeSubArraySum tester=new KSizeSubArraySum();
		int[] nums={1,2,7,4,-5,10,5};
		int k=3;
		int target=10;
		int[] res={0,4};
		assertTrue(tester.checkResult(tester.findSubArrayOfK(nums, k, target), res));
	}
}

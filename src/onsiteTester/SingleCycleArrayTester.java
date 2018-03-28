package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SingleCycleArray;

public class SingleCycleArrayTester {

	@Test
	public void test1() {
		SingleCycleArray tester=new SingleCycleArray();
		int[] nums={1,3};
		assertTrue(tester.isSingleCycleArray(nums));
	}
	@Test
	public void test2() {
		SingleCycleArray tester=new SingleCycleArray();
		int[] nums={1,2};
		assertTrue(!tester.isSingleCycleArray(nums));
	}
	@Test
	public void test3() {
		SingleCycleArray tester=new SingleCycleArray();
		int[] nums={1,2,3};
		assertTrue(!tester.isSingleCycleArray(nums));
	}
	@Test
	public void test4() {
		SingleCycleArray tester=new SingleCycleArray();
		int[] nums={1,2,2,7};
		assertTrue(tester.isSingleCycleArray(nums));
	}
	@Test
	public void test5() {
		SingleCycleArray tester=new SingleCycleArray();
		int[] nums={1,2,2,9,1};
		assertTrue(tester.isSingleCycleArray(nums));
	}
}

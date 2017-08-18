package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SubArrayLessThanK;

public class SubArrayLessThanKTester {

	@Test
	public void test() {
		SubArrayLessThanK tester=new SubArrayLessThanK();
		int[] nums1={5,2,6,1,2,-10,2,5,-2,1};
		assertTrue(tester.findMax(nums1, 5)==4);
		
	}

}

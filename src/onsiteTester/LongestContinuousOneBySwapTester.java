package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.LongestContinuousOneBySwap;

public class LongestContinuousOneBySwapTester {

	@Test
	public void test() {
		LongestContinuousOneBySwap swaper=new LongestContinuousOneBySwap();
		int[] num1={0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1};
		int k1=3;
		assertTrue(swaper.countMax(num1, k1)==9);
		assertTrue(swaper.countMax(num1, 2)==7);
		int[] num2={0,0,0,0,0,0};
		assertTrue(swaper.countMax(num2, k1)==0);
		int[] num3={1,1,0,0};
		assertTrue(swaper.countMax(num3, k1)==2);
		int[] num4={1,0,0,1};
		assertTrue(swaper.countMax(num4, k1)==2);
		assertTrue(swaper.countMax(num4, 1)==2);
		int[] num5={1,0,1,0};
		assertTrue(swaper.countMax(num5, k1)==2);
		int[] num6={0,0,1,1,1};
		assertTrue(swaper.countMax(num6, k1)==3);
	}

}

package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.HighestBoxStack;

public class HighestBoxStackTester {

	@Test
	public void test() {
		HighestBoxStack tester=new HighestBoxStack();
		int[] length={4,1,4,10};
		int[] width={6,2,5,12};
		int[] height={7,3,6,32};
		assertTrue(tester.findHight(length, width, height)==60);
	}

}

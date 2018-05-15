package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ReverseByteOfInteger;

public class ReverseByteOfIntegerTester {

	@Test
	public void test() {
		ReverseByteOfInteger tester=new ReverseByteOfInteger();
		for(int i=-100000;i<100000;i++){
			assertTrue(tester.reverseByte(i)==tester.reverseByteChecker(i));
		}
	}

}

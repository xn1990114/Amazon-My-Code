package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DuplicateArray;

public class DuplicateArrayTester {

	@Test
	public void test() {
		DuplicateArray da=new DuplicateArray();
		int[] a1={1,2,3,4,5};
		int[] a2={5,2,4,1,3};
		assertTrue(da.makeBStack(a1, a2)==null);
		int[] a3={3,1,2,5,4};
		assertTrue(da.makeBStack(a1, a3)==null);
		int[] a4={3,2,1,5,4};
		int[] r1=da.makeBStack(a1, a4);
		for(int i=0;i<r1.length;i++){
			assertTrue(r1[i]==a4[i]);
		}
	}

}

package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.ReArrangeElementWithStack;

public class ReArrangeElementWithStackTester {
	@Test
	public void test1() {
		ReArrangeElementWithStack tester=new ReArrangeElementWithStack();
		int[] ori={1,2,3,4,5,6,7,8,9};
		int[] target={1,2,3,4,5,6,7,8,9};
		List<Integer> res=tester.rearrange(ori, target);
		assertTrue(tester.sameRes(res, target));
	}
	@Test
	public void test2() {
		ReArrangeElementWithStack tester=new ReArrangeElementWithStack();
		int[] ori={1,2,3,4,5,6,7,8,9};
		int[] target={1,5,4,3,2,6,7,8,9};
		List<Integer> res=tester.rearrange(ori, target);
		assertTrue(tester.sameRes(res, target));
	}
	@Test
	public void test3() {
		ReArrangeElementWithStack tester=new ReArrangeElementWithStack();
		int[] ori={1,2,3,4,5,6,7,8,9};
		int[] target={1,2,3,5,4,7,8,6,9};
		List<Integer> res=tester.rearrange(ori, target);
		assertTrue(tester.sameRes(res, target));
	}
	@Test
	public void test4() {
		ReArrangeElementWithStack tester=new ReArrangeElementWithStack();
		int[] ori={1,2,3,4,5,6,7,8,9};
		int[] target={9,2,3,4,5,6,7,8,1};
		List<Integer> res=tester.rearrange(ori, target);
		assertTrue(!tester.sameRes(res, target));
	}
	// when not unique
	@Test
	public void test5() {
		ReArrangeElementWithStack tester=new ReArrangeElementWithStack();
		int[] ori={2,3,2,5,9};
		int[] target={2,5,3,9,2};
		List<Integer> res=tester.rearrange(ori, target);
		assertTrue(tester.sameRes(res, target));
	}
}

package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.PrisonCellProblem;

public class PrisonCellProblemTester {

	@Test
	public void test() {
		PrisonCellProblem tester=new PrisonCellProblem();
		Set<Integer> nums=new HashSet<Integer>();
		nums.add(2);
		nums.add(5);
		nums.add(13);
		assertTrue(tester.findMinCost(20, nums)==35);
	}

}

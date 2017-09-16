package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.LazyBarTender;

public class LazyBarTenderTester {

	@Test
	public void test() {
		LazyBarTender tester=new LazyBarTender();
		List<List<String>> req=new ArrayList<List<String>>();
		req.add(new ArrayList<String>());req.add(new ArrayList<String>());req.add(new ArrayList<String>());
		req.add(new ArrayList<String>());req.add(new ArrayList<String>());
		req.get(0).add("n3");req.get(0).add("n7");req.get(0).add("n5");req.get(0).add("n2");req.get(0).add("n9");
		req.get(1).add("n5");
		req.get(2).add("n2");req.get(2).add("n3");
		req.get(3).add("n4");
		req.get(4).add("n3");req.get(4).add("n4");req.get(4).add("n3");req.get(4).add("n5");req.get(4).add("n7");req.get(4).add("n4");
		assertTrue(tester.countDrinks(req)==3);
	}
}

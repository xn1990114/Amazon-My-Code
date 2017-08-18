package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DateDistance;

public class DateDistanceTester {

	@Test
	public void test() {
		DateDistance tester=new DateDistance();
		assertTrue(tester.withinOneMonth("Jul 1,2017", "Aug 1,2017"));
		assertTrue(!tester.withinOneMonth("Jul 18,2017", "Sep 1,2017"));
		assertTrue(tester.withinOneMonth("Jan 18,2017", "Dec 19,2016"));
		assertTrue(!tester.withinOneMonth("Jan 18,2017", "Dec 17,2016"));
		assertTrue(!tester.withinOneMonth("Jan 18,2017", "Dec 17,2017"));
	}

}

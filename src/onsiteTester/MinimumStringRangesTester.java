package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinimumStringRanges;

public class MinimumStringRangesTester {

	@Test
	public void test1() {
		MinimumStringRanges tester=new MinimumStringRanges();
		String s="Hello! today is Monday, tomorrow is Tuesday, yesterday is Sunday. today and tomorrow are sunny.";
		String[] keywords = {"is", "today", "tomorrow"};
		assertTrue(tester.findMinStringLen(s, keywords)==4);
	}
	@Test
	public void test2() {
		MinimumStringRanges tester=new MinimumStringRanges();
		String s="Hello! today is Monday, tomorrow is Tuesday, yesterday is Sunday. today and tomorrow are sunny.";
		String[] keywords = {"today", "tomorrow"};
		assertTrue(tester.findMinStringLen(s, keywords)==3);
	}
	@Test
	public void test3() {
		MinimumStringRanges tester=new MinimumStringRanges();
		String s="Hello! today is Monday, tomorrow is Tuesday, yesterday is Sunday. today and tomorrow are sunny.";
		String[] keywords = {"today", "tomorrow","hello"};
		assertTrue(tester.findMinStringLen(s, keywords)==5);
	}
}

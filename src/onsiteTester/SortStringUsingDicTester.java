package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SortStringUsingDic;

public class SortStringUsingDicTester {

	@Test
	public void test1() {
		SortStringUsingDic tester=new SortStringUsingDic();
		String s="ddloyc";
		String dic="odl";
		assertTrue(tester.sortStringWithComparator(s, dic).equals("oddlcy"));
		assertTrue(tester.sortStringWithOutComparator(s, dic).equals("oddlcy"));
	}

}

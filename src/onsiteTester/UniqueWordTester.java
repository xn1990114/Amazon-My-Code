package onsiteTester;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import onsite.UniqueWord;
/*
 * l1: chair,table, Nan, Xiao
 * l2:
 * l3: Xiao, table, table, table
 * l4: bottle,bottle,bottle,bottle,laptop
 * l5: laptop,chair
 */
public class UniqueWordTester {

	@Test
	public void test() {
		UniqueWord tester=new UniqueWord();
		List<List<String>> strs=new ArrayList<List<String>>();
		List<String> l1=new ArrayList<String>();
		List<String> l2=new ArrayList<String>();
		List<String> l3=new ArrayList<String>();
		List<String> l4=new ArrayList<String>();
		List<String> l5=new ArrayList<String>();
		strs.add(l1);strs.add(l2);strs.add(l3);strs.add(l4);strs.add(l5);
		l1.add("chair");l1.add("table");l1.add("Nan");l1.add("Xiao");
		l3.add("Xiao");l3.add("table");l3.add("table");l3.add("table");
		l4.add("bottle");l4.add("bottle");l4.add("bottle");l4.add("bottle");l4.add("laptop");
		l5.add("laptop");l5.add("chair");
		assertTrue(tester.findUnique(strs).equals("Nan"));
		l5.add("Nan");
		assertTrue(tester.findUnique(strs)==null);
		l5.add("Z");
		assertTrue(tester.findUnique(strs).equals("Z"));
	}

}

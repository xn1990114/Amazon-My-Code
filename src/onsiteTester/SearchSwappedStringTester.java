package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.SearchSwappedString;

public class SearchSwappedStringTester {

	@Test
	public void test() {
		SearchSwappedString tester=new SearchSwappedString();
		Set<String> dic=new HashSet<String>();
		dic.add("abc");dic.add("cba");dic.add("aaa");
		dic.add("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		dic.add("abcdefghijklmnopqrstuvwzzz");
		long startTime1 = System.nanoTime();
		long endTime1 = System.nanoTime();
		tester.dislayList(tester.findStringBS(dic, "tbcdefghijklmnopqrsauvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
		System.out.println("Took "+(endTime1 - startTime1)/1000/1000 + " ms"); 
		
		long startTime2 = System.nanoTime();
		tester.dislayList(tester.findString(dic, "abc"));
		tester.dislayList(tester.findString(dic, "aaa"));
		tester.dislayList(tester.findString(dic, "aaaa"));
		tester.dislayList(tester.findString(dic, "aa"));
		tester.dislayList(tester.findString(dic, "tbcdefghijklmnopqrsauvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
		long endTime2 = System.nanoTime();
		System.out.println("Took "+(endTime2 - startTime2)/1000/1000 + " ms"); 
	}

}

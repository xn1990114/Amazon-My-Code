package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.MostPopularBrowsingSequence;

public class MostPopularBrowsingSequenceTester {

	@Test
	public void test() {
		MostPopularBrowsingSequence tester=new MostPopularBrowsingSequence();
		String[][] his1={{"pageA","pageB","pageC","pageD","pageE","pageF"},
				{"pageA","pageB","pageC","pageD"},
				{"pageA","pageB","pageC","pageD"}};
		List<String> r1=tester.findMostPopular(his1);
		for(String s:r1){
			System.out.print(s+"\t");
		}
		System.out.println();
		String[][] his2={{"pageA","pageB","pageC","pageD","pageE","pageF"},
				{"pageA","pageD","pageE","pageF"},
				{"pageA","pageC","pageD","pageE"}};
		List<String> r2=tester.findMostPopular(his2);
		for(String s:r2){
			System.out.print(s+"\t");
		}
		System.out.println();
	}

}

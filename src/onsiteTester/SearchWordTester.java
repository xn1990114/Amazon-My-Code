package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.SearchWord;

public class SearchWordTester {

	@Test
	public void test() {
		Set<String> dic=new HashSet<String>();
		dic.add("xiao");dic.add("nan");dic.add("man");dic.add("jiao");dic.add("yaoo");
		dic.add("wgcn");dic.add("a aa");dic.add("a bc");
		SearchWord tester=new SearchWord();
		List<String> res1=tester.findWords("9426", dic);
		for(String s:res1){
			System.out.println(s);
		}
		List<String> res2=tester.findWords("2022", dic);
		for(String s:res2){
			System.out.println(s);
		}
		List<String> res3=tester.findWords("2122", dic);
		for(String s:res3){
			System.out.println(s);
		}
	}

}

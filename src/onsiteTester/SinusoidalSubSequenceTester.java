package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SinusoidalSubSequence;

public class SinusoidalSubSequenceTester {

	@Test
	public void test() {
		SinusoidalSubSequence tester=new SinusoidalSubSequence();
		String s1="arun";
		assertTrue(tester.pathSubSequence(s1).equals("arn"));
		String s2="srunab";
		assertTrue(tester.pathSubSequence(s2).equals("ruab"));
		String s3="sa";
		assertTrue(tester.pathSubSequence(s3).equals("a"));
		String s4="";
		assertTrue(tester.pathSubSequence(s4).equals(""));
		String s5="a";
		assertTrue(tester.pathSubSequence(s5).equals("a"));
		String s6="sraunsadbc";
		assertTrue(tester.pathSubSequence(s6).equals("aunsadbc"));
		String s7="sraunsacdfgsa";
		assertTrue(tester.pathSubSequence(s7).equals("aunsaca"));
		String s8="sraunsaaaaaacdfgsa";
		assertTrue(tester.pathSubSequence(s8).equals("aunsaca"));
	}

}

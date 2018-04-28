package phoneTester;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import phone.SubStringOfSizeKWithOnlyUniqueLetters;

public class SubStringOfSizeKWithOnlyUniqueLettersTester {

	@Test
	public void test1() {
		SubStringOfSizeKWithOnlyUniqueLetters tester=new SubStringOfSizeKWithOnlyUniqueLetters();
		String s="absadakja";
		int k=3;
		String[] res={"abs","bsa","sad","dak","akj","kja"};
		assertTrue(tester.sameResult(tester.findSubstringWithUniqueLetter(s, k), res));
	}

	@Test
	public void test2() {
		SubStringOfSizeKWithOnlyUniqueLetters tester=new SubStringOfSizeKWithOnlyUniqueLetters();
		String s="absadakja";
		int k=4;
		String[] res={"bsad","dakj"};
		assertTrue(tester.sameResult(tester.findSubstringWithUniqueLetter(s, k), res));
	}
	
	@Test
	public void test3() {
		SubStringOfSizeKWithOnlyUniqueLetters tester=new SubStringOfSizeKWithOnlyUniqueLetters();
		String s="absadakja";
		int k=9;
		String[] res={};
		assertTrue(tester.sameResult(tester.findSubstringWithUniqueLetter(s, k), res));
	}
	
	@Test
	public void test4() {
		SubStringOfSizeKWithOnlyUniqueLetters tester=new SubStringOfSizeKWithOnlyUniqueLetters();
		String s="absadakja";
		int k=10;
		String[] res={};
		assertTrue(tester.sameResult(tester.findSubstringWithUniqueLetter(s, k), res));
	}
}

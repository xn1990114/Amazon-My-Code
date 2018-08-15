package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.ConvertWord;

public class ConvertWordTester {

	@Test
	public void test() {
		ConvertWord tester=new ConvertWord();
		String word1="fs";
		assertTrue(tester.convertWord(word1, 3).equals("iv"));
		String word2="fs.ders@1241";
		assertTrue(tester.convertWord(word2, -10).equals("vi.tuhi@1241"));
		String sentence1="fs.ders@1241s!";
		assertTrue(tester.convertSentence(sentence1, -10).equals("vi.ders@1241s!"));
		String sentence2="fs.ders@1241r!";
		assertTrue(tester.convertSentence(sentence2, 53).equals("gt.cdqr@1241q!"));
		String sentence3="fs..ders@1241r!.";
		assertTrue(tester.convertSentence(sentence3, 53).equals("gt..ders@1241r!."));
		
	}

}

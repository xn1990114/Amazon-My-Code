package design_TextEditor;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class TextPadtester {

	@Test
	public void test() {
		TextPad tester = new TextPad(3);
		tester.addLetter('a');tester.addLetter('a');tester.addLetter('a');
		tester.addLetter('a');tester.addLetter('a');
		for(String s:tester.content){
			System.out.println(s);
		}
		tester.deleteLetter();
		for(String s:tester.content){
			System.out.println(s);
		}
		tester.deleteLetter();
		for(String s:tester.content){
			System.out.println(s);
		}
		tester.deleteLetter();
		for(String s:tester.content){
			System.out.println(s);
		}
	}

}

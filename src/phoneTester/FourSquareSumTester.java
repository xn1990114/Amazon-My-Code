package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.FourSquareSum;

public class FourSquareSumTester {

	@Test
	public void test() {
		FourSquareSum tester=new FourSquareSum();
		tester.printResult(tester.find4SquareSum(0));
		tester.printResult(tester.find4SquareSum(4));
		tester.printResult(tester.find4SquareSum(15));
		tester.printResult(tester.find4SquareSum(-4));
		tester.printResult(tester.find4SquareSum(120));
	}

}

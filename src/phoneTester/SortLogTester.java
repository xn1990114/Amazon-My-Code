package phoneTester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import phone.SortLog;

public class SortLogTester {

	@Test
	public void test() {
		SortLog tester=new SortLog();
		List<String> logs=new ArrayList<String>();
		logs.add("a1 4 2 3 1");logs.add("g1 Act car");logs.add("zo4 9 7");logs.add("ab1 Act KEYdog");
		logs.add("p2 7 7 2");logs.add("ab1 Act KEY dog");logs.add("a8 act zoo");
		String[] exp={"ab1 Act KEY dog","ab1 Act KEYdog","g1 Act car","a8 act zoo","a1 4 2 3 1","zo4 9 7","p2 7 7 2"};
		List<String> sortedLog=tester.sort(logs);
		assertTrue(sortedLog.size()==exp.length);
		for(int i=0;i<exp.length;i++){
			assertTrue(exp[i].equals(sortedLog.get(i)));
		}
	}

}

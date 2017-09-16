package onsiteTester;

import org.junit.Test;
import onsite.MostOverlappedInterval;
import onsite.MostOverlappedInterval.Interval;

public class MostOverlappedIntervalTester {

	@Test
	public void test() {
		MostOverlappedInterval tester=new MostOverlappedInterval();
		Interval[] input1={tester.new Interval(-5,-2),
				tester.new Interval(0,4),
				tester.new Interval(-1,3),
				tester.new Interval(2,3),
				tester.new Interval(3,7),
				tester.new Interval(-4,7),
				tester.new Interval(6,7),
				tester.new Interval(6,7),};
		System.out.println(tester.findMostOverlappedInterval(input1));
		Interval[] input2={tester.new Interval(0,1),
						tester.new Interval(1,3),
						tester.new Interval(2,3),
						tester.new Interval(3,4),
						tester.new Interval(3,4)};
		System.out.println(tester.findMostOverlappedInterval(input2));
	}

}

package phoneTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import phone.MedianOfNArray;

public class MedianOfNArrayTester {

	@Test
	public void test() {
		MedianOfNArray tester=new MedianOfNArray();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> l1=new ArrayList<Integer>();l1.add(0);l1.add(10);l1.add(13);l1.add(17);l1.add(20);
		List<Integer> l2=new ArrayList<Integer>();l2.add(0);l2.add(0);l2.add(7);l2.add(13);
		List<Integer> l3=new ArrayList<Integer>();l3.add(-5);l3.add(-2);l3.add(14);l3.add(25);
		List<Integer> l4=new ArrayList<Integer>();
		List<Integer> l5=new ArrayList<Integer>();l5.add(2);l5.add(4);l5.add(5);
		list.add(l1);list.add(l2);list.add(l3);list.add(l4);list.add(l5);
		System.out.println(tester.findMedian(list));
		l5.add(8);
		System.out.println(tester.findMedian(list));
	}

}

package onsiteTester;

import org.junit.Test;

import onsite.ArrayToQueue;

public class ArrayToQueueTester {

	@Test
	public void test() throws Exception {
		ArrayToQueue tester=new ArrayToQueue(3);
		tester.offer(1);
		tester.offer(2);
		tester.offer(3);
		for(int i=0;i<3;i++){
			System.out.print(tester.content[i]);
		}
		System.out.println();
		tester.offer(4);
		tester.offer(5);
		for(int i=0;i<3;i++){
			System.out.print(tester.content[i]);
		}
		System.out.println();
		while(!tester.isEmpty()){
			System.out.println(tester.poll());
		}
	}

}

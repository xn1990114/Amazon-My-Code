package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.SmartQueue;

public class SmartQueueTester {

	@Test
	public void test1() {
		SmartQueue sq=new SmartQueue();
		sq.offer("a", 1);
		sq.offer("b", 3);
		sq.offer("b", 4);
		assertTrue(sq.poll()==1);
		assertTrue(sq.poll()==4);
		assertTrue(sq.poll()==null);
	}
	@Test
	public void test2() {
		SmartQueue sq=new SmartQueue();
		sq.offer("a", 1);
		sq.offer("b", 3);
		sq.offer("a", 5);
		assertTrue(sq.poll()==3);
		assertTrue(sq.poll()==5);
		assertTrue(sq.poll()==null);
	}
	@Test
	public void test3() {
		SmartQueue sq=new SmartQueue();
		sq.offer("a", 1);
		sq.offer("b", 3);
		sq.offer("b", 4);
		assertTrue(sq.poll()==1);
		sq.offer("a", 2);
		assertTrue(sq.poll()==4);
		sq.offer("a", 3);
		assertTrue(sq.poll()==3);
		assertTrue(sq.poll()==null);
	}

}

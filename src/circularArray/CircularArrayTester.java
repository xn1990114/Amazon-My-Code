package circularArray;

import java.util.Iterator;

import org.junit.Test;

public class CircularArrayTester {

	@Test
	public void test() {
		CircularArray<String> ca=new CircularArray<String>();
		ca.add("first");
		ca.add("sec");
		ca.add("3rd");
		ca.add("4th");
		Iterator<String> it=ca.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		System.out.println();
		ca.remove("sec");
		it=ca.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		System.out.println();
		ca.add("sec");
		ca.rotate();
		it=ca.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		System.out.println();
		ca.add("sec");
		it=ca.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		System.out.println();
		ca.remove("3rd");
		it=ca.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
	}

}

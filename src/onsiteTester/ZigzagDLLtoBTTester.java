package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ZigzagDLLtoBT;
import onsite.ZigzagDLLtoBT.Node;

public class ZigzagDLLtoBTTester {

	@Test
	public void test1() {
		ZigzagDLLtoBT tester=new ZigzagDLLtoBT();
		Node n1=tester.new Node(1);Node n2=tester.new Node(2);Node n3=tester.new Node(3);
		Node n4=tester.new Node(4);Node n5=tester.new Node(5);Node n6=tester.new Node(6);
		Node n7=tester.new Node(7);Node n8=tester.new Node(8);
		n1.right=n2;n2.left=n1;n2.right=n3;n3.left=n2;n3.right=n4;n4.left=n3;n4.right=n5;
		n5.left=n4;n5.right=n6;n6.left=n5;n6.right=n7;n7.left=n6;n7.right=n8;n8.left=n7;
		tester.convertToBT(n1);
		tester.displayTree(n1);
		
	}
	@Test
	public void test2() {
		ZigzagDLLtoBT tester=new ZigzagDLLtoBT();
		Node n1=tester.new Node(1);Node n2=tester.new Node(2);Node n3=tester.new Node(3);
		Node n4=tester.new Node(4);Node n5=tester.new Node(5);Node n6=tester.new Node(6);
		Node n7=tester.new Node(7);Node n8=tester.new Node(8);Node n9=tester.new Node(9);
		Node n10=tester.new Node(10);Node n11=tester.new Node(11);Node n12=tester.new Node(12);
		Node n13=tester.new Node(13);Node n14=tester.new Node(14);
		n1.right=n2;n2.left=n1;n2.right=n3;n3.left=n2;n3.right=n4;n4.left=n3;n4.right=n5;
		n5.left=n4;n5.right=n6;n6.left=n5;n6.right=n7;n7.left=n6;n7.right=n8;n8.left=n7;
		n8.right=n9;n9.left=n8;n9.right=n10;n10.left=n9;n10.right=n11;n11.left=n10;n11.right=n12;
		n12.left=n11;n12.right=n13;n13.left=n12;n13.right=n14;n14.left=n13;
		tester.convertToBT(n1);
		tester.displayTree(n1);
	}
	@Test
	public void test3() {
		ZigzagDLLtoBT tester=new ZigzagDLLtoBT();
		Node n1=tester.new Node(1);Node n2=tester.new Node(2);Node n3=tester.new Node(3);
		Node n4=tester.new Node(4);
		n1.right=n2;n2.left=n1;n2.right=n3;n3.left=n2;n3.right=n4;n4.left=n3;
		tester.convertToBT(n1);
		tester.displayTree(n1);
	}
	@Test
	public void test4() {
		ZigzagDLLtoBT tester=new ZigzagDLLtoBT();
		Node n1=tester.new Node(1);Node n2=tester.new Node(2);Node n3=tester.new Node(3);
		Node n4=tester.new Node(4);Node n5=tester.new Node(5);Node n6=tester.new Node(6);
		Node n7=tester.new Node(7);Node n8=tester.new Node(8);Node n9=tester.new Node(9);
		n1.right=n2;n2.left=n1;n2.right=n3;n3.left=n2;n3.right=n4;n4.left=n3;n4.right=n5;
		n5.left=n4;n5.right=n6;n6.left=n5;n6.right=n7;n7.left=n6;n7.right=n8;n8.left=n7;
		n8.right=n9;n9.left=n8;
		tester.convertToBT(n1);
		tester.displayTree(n1);
	}
	@Test
	public void test5() {
		ZigzagDLLtoBT tester=new ZigzagDLLtoBT();
		Node n1=tester.new Node(1);Node n2=tester.new Node(2);Node n3=tester.new Node(3);
		Node n4=tester.new Node(4);Node n5=tester.new Node(5);Node n6=tester.new Node(6);
		Node n7=tester.new Node(7);Node n8=tester.new Node(8);Node n9=tester.new Node(9);
		Node n10=tester.new Node(10);Node n11=tester.new Node(11);Node n12=tester.new Node(12);
		Node n13=tester.new Node(13);Node n14=tester.new Node(14);Node n15=tester.new Node(15);
		n1.right=n2;n2.left=n1;n2.right=n3;n3.left=n2;n3.right=n4;n4.left=n3;n4.right=n5;
		n5.left=n4;n5.right=n6;n6.left=n5;n6.right=n7;n7.left=n6;n7.right=n8;n8.left=n7;
		n8.right=n9;n9.left=n8;n9.right=n10;n10.left=n9;n10.right=n11;n11.left=n10;n11.right=n12;
		n12.left=n11;n12.right=n13;n13.left=n12;n13.right=n14;n14.left=n13;n14.right=n15;
		n15.left=n14;
		tester.convertToBT(n1);
		tester.displayTree(n1);
	}

}

package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.BSTtoDLL;
import onsite.BSTtoDLL.Node;
import onsite.BSTtoDLL.TreeNode;

public class BSTtoDLLTester {
/*
 * 						5
 * 			2								10
 * 		1		3					7				  15
 * -100				4			6		8		 	  		20
 * 
 */
	@Test
	public void test1() {
		BSTtoDLL bd=new BSTtoDLL();
		TreeNode n5=bd.new TreeNode(5);
		TreeNode n2=bd.new TreeNode(2);TreeNode n10=bd.new TreeNode(10);
		TreeNode n1=bd.new TreeNode(1);TreeNode n3=bd.new TreeNode(3);TreeNode n7=bd.new TreeNode(7);TreeNode n15=bd.new TreeNode(15);
		TreeNode n_100=bd.new TreeNode(-100);TreeNode n4=bd.new TreeNode(4);TreeNode n6=bd.new TreeNode(6);TreeNode n8=bd.new TreeNode(8);TreeNode n20=bd.new TreeNode(20);
		n5.left=n2; n5.right=n10;
		n2.left=n1;n2.right=n3;n10.left=n7;n10.right=n15;
		n1.left=n_100;n3.right=n4;n7.left=n6;n7.right=n8;n15.right=n20;
		TreeNode head=bd.convertToDDLUsingMorris(n5);
		bd.display(head);
		System.out.println();
	}
	@Test
	public void test2() {
		BSTtoDLL bd=new BSTtoDLL();
		TreeNode n5=bd.new TreeNode(5);
		TreeNode n2=bd.new TreeNode(2);TreeNode n10=bd.new TreeNode(10);
		TreeNode n1=bd.new TreeNode(1);TreeNode n3=bd.new TreeNode(3);TreeNode n7=bd.new TreeNode(7);TreeNode n15=bd.new TreeNode(15);
		TreeNode n_100=bd.new TreeNode(-100);TreeNode n4=bd.new TreeNode(4);TreeNode n6=bd.new TreeNode(6);TreeNode n8=bd.new TreeNode(8);TreeNode n20=bd.new TreeNode(20);
		n5.left=n2; n5.right=n10;
		n2.left=n1;n2.right=n3;n10.left=n7;n10.right=n15;
		n1.left=n_100;n3.right=n4;n7.left=n6;n7.right=n8;n15.right=n20;
		TreeNode head=bd.convertToDDLUsingStack(n5);
		bd.display(head);
		System.out.println();
	}
	@Test
	public void test3() {
		BSTtoDLL bd=new BSTtoDLL();
		TreeNode n5=bd.new TreeNode(5);
		TreeNode n2=bd.new TreeNode(2);TreeNode n10=bd.new TreeNode(10);
		TreeNode n1=bd.new TreeNode(1);TreeNode n3=bd.new TreeNode(3);TreeNode n7=bd.new TreeNode(7);TreeNode n15=bd.new TreeNode(15);
		TreeNode n_100=bd.new TreeNode(-100);TreeNode n4=bd.new TreeNode(4);TreeNode n6=bd.new TreeNode(6);TreeNode n8=bd.new TreeNode(8);TreeNode n20=bd.new TreeNode(20);
		n5.left=n2; n5.right=n10;
		n2.left=n1;n2.right=n3;n10.left=n7;n10.right=n15;
		n1.left=n_100;n3.right=n4;n7.left=n6;n7.right=n8;n15.right=n20;
		Node head=bd.convert(n5);
		bd.display(head);
	}

}

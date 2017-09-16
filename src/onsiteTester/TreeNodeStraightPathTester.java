package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;
import onsite.TreeNodeStraightPath;
import onsite.TreeNodeStraightPath.TreeNode;
/*
 * 							5
 * 				6					 3
 *  		1      7		   9		    12
 *  	10		      2            13      4   11
 *  							  8
 *  							14
 */
public class TreeNodeStraightPathTester {

	@Test
	public void test() {
		TreeNodeStraightPath tester=new TreeNodeStraightPath();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);TreeNode n8=tester.new TreeNode(8);
		TreeNode n9=tester.new TreeNode(9);TreeNode n10=tester.new TreeNode(10);
		TreeNode n11=tester.new TreeNode(11);TreeNode n12=tester.new TreeNode(12);
		TreeNode n13=tester.new TreeNode(13);TreeNode n14=tester.new TreeNode(14);
		n5.left=n6;n5.right=n3;n6.left=n1;n6.right=n7;n1.left=n10;n7.right=n2;
		n3.left=n9;n3.right=n12;n9.right=n13;n13.left=n8;n8.left=n14;n12.left=n4;n12.right=n11;
		assertTrue(tester.countTurns(n5, n14, n2)==5);
		assertTrue(tester.countTurns(n5, n2, n14)==5);
		assertTrue(tester.countTurns(n5, n2, n6)==0);
		assertTrue(tester.countTurns(n5, n2, n10)==1);
		assertTrue(tester.countTurns(n5, n5, n14)==3);
		assertTrue(tester.countTurns(n5, n6, n2)==0);
		assertTrue(tester.countTurns(n5, n3, n13)==1);
	}

}

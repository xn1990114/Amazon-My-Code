package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.isSumTree;
import onsite.isSumTree.TreeNode;

public class isSumTreeTester {

	@Test
	public void test() {
		isSumTree tester=new isSumTree();
		TreeNode n0=tester.new TreeNode(26);
		TreeNode n1=tester.new TreeNode(10);
		TreeNode n2=tester.new TreeNode(4);
		TreeNode n3=tester.new TreeNode(6);
		TreeNode n4=tester.new TreeNode(3);
		TreeNode n5=tester.new TreeNode(3);
		n0.left=n1;n1.left=n2;n1.right=n3;n0.right=n4;n4.right=n5;
		assertTrue(tester.isValid(n0));
	}

}

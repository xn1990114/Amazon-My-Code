package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SameInorderTreeChecker;
import onsite.SameInorderTreeChecker.Node;
/*Tree 1
 * 					5
 * 			3					8
 * 	     2		4		6
 *    1						7
 *    
 * Tree 2
 * 					2
 * 			1						8
 * 							  7
 * 						  5
 * 					  3      6
 * 						4
 */


public class SameInorderTreeCheckerTester {

	@Test
	public void test() {
		SameInorderTreeChecker checker=new SameInorderTreeChecker();
		Node n11=checker.new Node(1);Node n12=checker.new Node(2);Node n13=checker.new Node(3);Node n14=checker.new Node(4);
		Node n15=checker.new Node(5);Node n16=checker.new Node(6);Node n17=checker.new Node(7);Node n18=checker.new Node(8);
		Node n21=checker.new Node(1);Node n22=checker.new Node(2);Node n23=checker.new Node(3);Node n24=checker.new Node(4);
		Node n25=checker.new Node(5);Node n26=checker.new Node(6);Node n27=checker.new Node(7);Node n28=checker.new Node(8);
		n12.left=n11;n13.left=n12;n13.right=n14;n15.left=n13;n15.right=n18;n18.left=n16;n16.right=n17;
		n22.left=n21;n22.right=n28;n28.left=n27;n27.left=n25;n25.left=n23;n25.right=n26;n23.right=n24;
		assertTrue(checker.checkSame(n15, n22));
	}

}

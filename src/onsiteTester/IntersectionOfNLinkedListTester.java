package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.IntersectionOfNLinkedList;
import onsite.IntersectionOfNLinkedList.ListNode;
/*
 * 1-2-3-4-5-6-7-8-9
 * 10-11-12-7-8-9
 * 7-8-9
 * 13-4-5-6-7-8-9
 * 2-3-4-5-6-7-8-9
 */
public class IntersectionOfNLinkedListTester {

	@Test
	public void test() {
		IntersectionOfNLinkedList tester=new IntersectionOfNLinkedList();
		ListNode[] nodeMap=new ListNode[15];
		for(int i=1;i<nodeMap.length;i++){
			nodeMap[i]=tester.new ListNode();
		}
		nodeMap[1].next=nodeMap[2];nodeMap[2].next=nodeMap[3];nodeMap[3].next=nodeMap[4];
		nodeMap[4].next=nodeMap[5];nodeMap[5].next=nodeMap[6];nodeMap[6].next=nodeMap[7];
		nodeMap[7].next=nodeMap[8];nodeMap[8].next=nodeMap[9];nodeMap[10].next=nodeMap[11];
		nodeMap[11].next=nodeMap[12];nodeMap[12].next=nodeMap[7];nodeMap[13].next=nodeMap[4];
		List<ListNode> nodes=new ArrayList<ListNode>();
		nodes.add(nodeMap[1]);nodes.add(nodeMap[10]);nodes.add(nodeMap[7]);nodes.add(nodeMap[13]);
		nodes.add(nodeMap[2]);
		assertTrue(tester.findIntersection(nodes)==nodeMap[7]);
		nodes.add(nodeMap[0]);
		assertTrue(tester.findIntersection(nodes)==null);
		nodes.remove(nodes.size()-1);
		nodes.add(nodeMap[14]);
		assertTrue(tester.findIntersection(nodes)==null);
	}

}

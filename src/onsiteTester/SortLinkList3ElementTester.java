package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.IntersectionOfNLinkedList.ListNode;
import onsite.SortLinkList3Element;

public class SortLinkList3ElementTester {

	@Test
	public void test1() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={1,2,1,1,1,1,1,1};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test2() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={1,2,1,3,3,1,1,1};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test3() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={3,2,3,3,3};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test4() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test5() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={3,3,3,3};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test6() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={1,1,1,1};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test7() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={2,2,2,2};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	@Test
	public void test8() {
		SortLinkList3Element tester=new SortLinkList3Element();
		int[] nums={2};
		onsite.SortLinkList3Element.ListNode head=tester.makeList(nums);
		head=tester.sortList(head);
		while(head!=null){
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
}

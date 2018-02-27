package onsite;
//Sort the linked list which contains only 1,2,3 numbers in a single pass
public class SortLinkList3Element {
	public class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	public ListNode sortList(ListNode head){
		ListNode head1=new ListNode(0);
		ListNode head2=new ListNode(0);
		ListNode head3=new ListNode(0);
		ListNode parent1=head1;
		ListNode parent2=head2;
		ListNode parent3=head3;
		ListNode curr=head;
		while(curr!=null){
			ListNode next=curr.next;
			if(curr.val==1){
				parent1.next=curr;
				parent1=curr;
				parent1.next=null;
			}
			else if(curr.val==2){
				parent2.next=curr;
				parent2=curr;
				parent2.next=null;
			}
			else{
				parent3.next=curr;
				parent3=curr;
				parent3.next=null;
			}
			curr=next;
		}
		parent2.next=head3.next;
		parent1.next=head2.next;
		return head1.next;
	}
	public ListNode makeList(int[] nums){
		ListNode head=new ListNode(0);
		ListNode parent=head;
		for(int i=0;i<nums.length;i++){
			parent.next=new ListNode(nums[i]);
			parent=parent.next;
		}
		return head.next;
	}
}

package onsite;
import java.util.*;

public class IntersectionOfNLinkedList {
	public class ListNode{
		public ListNode next;
	}
	public ListNode findIntersection(List<ListNode> nodes){
		if(nodes.size()==0){
			return null;
		}
		ListNode curr=nodes.get(0);
		for(int i=1;i<nodes.size()&&curr!=null;i++){
			curr=getIntersectionNode(curr,nodes.get(i));
		}
		return curr;
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        boolean b1=false;
        boolean b2=false;
        while(l1!=null&&l2!=null&&l1!=l2){
            l1=l1.next;
            l2=l2.next;
            if(l1==null&&!b1){
                b1=true;
                l1=headB;
            }
            if(l2==null&&!b2){
                b2=true;
                l2=headA;
            }
        }
        if(l1==null||l2==null){
            return null;
        }
        return l1;
    }
}

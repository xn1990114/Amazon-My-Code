package phone;
import java.util.*;
/*
 * Implement a 'smart' queue where it automatically dedups elements by its keys.e.g.,
push (a, 1)
push (b, 2)
push (a, 3) 
since (a, 1) already in queue, this will only update (a, 1) to (a, 3).
now the queue should look like:
(a, 3), (b, 2)
 */
public class SmartQueue {
	class ListNode{
		ListNode pre;
		ListNode next;
		String key;
		public ListNode(String key){
			this.key=key;
		}
	}
	Map<String,Integer> valueMap;
	Map<String,ListNode> nodeMap;
	ListNode head;
	ListNode tail;
	public SmartQueue(){
		this.head=new ListNode("");
		this.tail=new ListNode("");
		head.next=tail;
		tail.pre=head;
		this.valueMap=new HashMap<String,Integer>();
		this.nodeMap=new HashMap<String,ListNode>();
	}
	public Integer poll(){
		if(this.valueMap.isEmpty()){
			return null;
		}
		ListNode toremove=tail.pre;
		toremove.pre.next=tail;
		tail.pre=toremove.pre;
		Integer res=valueMap.get(toremove.key);
		valueMap.remove(toremove.key);
		nodeMap.remove(toremove.key);
		return res;
	}
	public void offer(String key,int value){
		if(!valueMap.containsKey(key)){
			nodeMap.put(key, new ListNode(key));
		}
		valueMap.put(key, value);
		ListNode currNode=nodeMap.get(key);
		if(currNode.pre!=null){
			currNode.pre.next=currNode.next;
			currNode.next.pre=currNode.pre;
		}
		currNode.next=head.next;
		head.next.pre=currNode;
		head.next=currNode;
		currNode.pre=head;
	}
}

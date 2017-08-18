package circularArray;
import java.util.*;

public class CircularArray<T> implements Iterable<T>{
	Node<T> head;
	Map<T,Node<T>> map;
	public CircularArray(){
		this.map=new HashMap<T,Node<T>>();
	}
	public void add(T t){
		if(map.containsKey(t)){
			this.remove(t);
			this.add(t);
			return;
		}
		Node<T> toadd=new Node<T>(t);
		if(head==null){
			head=toadd;
			head.next=head;
			head.previous=head;
			return;
		}
		head.previous.next=toadd;
		toadd.previous=head.previous;
		toadd.next=head;
		head.previous=toadd;
		map.put(t, toadd);
	}
	public void remove(T t){
		if(!this.map.containsKey(t)){
			return;
		}
		Node<T> curr=map.get(t);
		map.remove(t);
		if(curr==head){
			if(head.next==head){
				head=null;
				return;
			}
			else{
				head=head.next;
			}
		}
		curr.previous.next=curr.next;
		curr.next.previous=curr.previous;
	}
	public void rotate(){
		this.head=head.next;
	}
	public Iterator<T> iterator(){
		return new ArrayIterator<T>(this);
	}
}

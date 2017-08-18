package circularArray;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T>{
	Node<T> curr;
	boolean started;
	Node<T> head;
	public ArrayIterator(CircularArray<T> a){
		this.curr=a.head;
		this.head=a.head;
	}
	public boolean hasNext(){
		if(curr==null){
			return false;
		}
		if(started&&curr==head){
			return false;
		}
		return true;
	}
	public T next(){
		Node<T> result=curr;
		started=true;
		curr=curr.next;
		return result.val;
	}
}
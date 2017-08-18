package circularArray;


public class Node <T>{
	T val;
	Node<T> previous;
	Node<T> next;
	public Node(T t){
		this.val=t;
	}
}

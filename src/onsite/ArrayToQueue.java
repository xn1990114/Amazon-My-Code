package onsite;

public class ArrayToQueue {
	public int[] content;
	int start;
	int end;
	int size;
	public ArrayToQueue(int capacity){
		this.start=0;
		this.end=0;
		this.size=0;
		this.content=new int[capacity];
	}
	public boolean isEmpty(){
		return this.size==0;
	}
	public void offer(int val) throws Exception{
		if(start==end&&this.size>0){
			poll();
		}
		content[end]=val;
		end=(end+1)%content.length;
		size++;
	}
	public int poll() throws Exception{
		if(this.size==0){
			throw new Exception("empty queue");
		}
		int res=this.content[start];
		start=(start+1)%content.length;
		size--;
		return res;
	}
}

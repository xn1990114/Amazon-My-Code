package hashMap;
import java.util.*;
public class MyHashMap <K,V> {
	List<Pair<K,V>>[] lists;
	public MyHashMap(){
		lists=new ArrayList[5000];
		for(int i=0;i<5000;i++){
			lists[i]=new ArrayList<Pair<K,V>>();
		}
	}
	public int calHash(K k){
		return k.toString().length()%5000;
	}
	public void put(K k,V v){
		int hash=calHash(k);
		List<Pair<K,V>> curr=this.lists[hash];
		for(Pair<K,V> p:curr){
			if(p.key==k){
				p.value=v;
				return;
			}
		}
		curr.add(new Pair<K,V>(k,v));
	}
	public V get(K key){
		int hash=calHash(key);
		List<Pair<K,V>> curr=this.lists[hash];
		for(Pair<K,V> p:curr){
			if(p.key==key){
				return p.value;
			}
		}
		return null;
	}
	public void remove(K key){
		int hash=calHash(key);
		List<Pair<K,V>> curr=this.lists[hash];
		for(int i=0;i<curr.size();i++){
			if(curr.get(i).key==key){
				curr.remove(i);
				return;
			}
		}
	}
}

package jukeBox;
import java.util.*;

public class JukeBox {
	Map<String,Song> memory;
	List<String> myPlayList;
	public JukeBox(){
		this.memory=new HashMap<String,Song>();
		this.myPlayList=new ArrayList<String>();
	}
	
	public boolean addNewSong(Song s){
		String key=s.getName();
		if(this.memory.keySet().contains(key)){
			return false;
		}
		this.memory.put(key, s);
		return true;
	}
	public boolean deleteSong(String name){
		if(this.memory.keySet().contains(name)){
			this.memory.remove(name);
			return true;
		}
		return false;
	}
	
	public boolean addSongToList(String name){
		if(!this.memory.keySet().contains(name)){
			return false;
		}
		if(this.myPlayList.contains(name)){
			return false;
		}
		this.myPlayList.add(name);
		return true;
	}
	public boolean removeSongToList(String name){
		if(!this.myPlayList.contains(name)){
			return false;
		}
		this.myPlayList.remove(name);
		return true;
	}
	public void shuffleList(){
		for(int i=this.myPlayList.size()-1;i>=0;i--){
			int index=(int)(Math.random()*this.myPlayList.size());
			String temp=this.myPlayList.get(index);
			this.myPlayList.set(index, this.myPlayList.get(i));
			this.myPlayList.set(i, temp);
		}
	}
	public void playSongs(){
		for(String key:this.myPlayList){
			if(!this.memory.keySet().contains(key)){
				continue;
			}
			this.memory.get(key).play();
		}
	}
	public void createNewList(){
		this.myPlayList=new ArrayList<String>(this.memory.keySet());
	}
}

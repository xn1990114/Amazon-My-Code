package design_FileSystem;

import java.util.TreeMap;

public class Folder extends Obj{
	public Folder(String name){
        this.name=name;
        this.child=new TreeMap<String,Obj>();
    }
}

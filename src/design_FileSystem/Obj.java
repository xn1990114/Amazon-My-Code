package design_FileSystem;

import java.util.TreeMap;

public abstract class Obj {
	Obj parent;
	String name;
	String Path;
    TreeMap<String,Obj> child;
    StringBuilder content;
    public boolean isFile(){
    	return this.child==null;
    }
    public Obj getParent(){
    	return this.parent;
    }
}

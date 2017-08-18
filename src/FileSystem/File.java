package FileSystem;

public class File extends Obj{
	public File(String name){
        this.name=name;
        this.content=new StringBuilder();
    }
}

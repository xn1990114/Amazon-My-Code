package design_FileSystem;
import java.util.*;

// lc 588
public class FileSystem {
    Obj root;
    public FileSystem() {
        this.root=new Folder("");
    }
    
    public List<String> ls(String path) {
        Obj curr=root;
        String[] a=path.split("/");
        for(int i=1;i<a.length;i++){
            curr=curr.child.get(a[i]);
        }
        List<String> result=new ArrayList<String>();
        if(curr instanceof File){
            result.add(curr.name);
        }
        else{
            result.addAll(curr.child.keySet());
        }
        return result;
    }
    
    public void mkdir(String path) {
        Obj curr=root;
        Obj parent=null;
        String[] a=path.split("/");
        for(int i=1;i<a.length;i++){
            if(!curr.child.containsKey(a[i])){
                curr.child.put(a[i],new Folder(a[i]));
                curr.child.get(a[i]).parent=parent;
            }
            curr=curr.child.get(a[i]);
            parent=curr;
        }
        curr.Path=path;
    }
    
    public void addContentToFile(String filePath, String content) {
        Obj curr=root;
        Obj parent=null;
        String[] a=filePath.split("/");
        for(int i=1;i<a.length;i++){
            if(!curr.child.containsKey(a[i])){
                curr.child.put(a[i],new File(a[i]));
                curr.child.get(a[i]).parent=parent;
            }
            curr=curr.child.get(a[i]);
            parent=curr;
        }
        curr.content.append(content);
        curr.Path=filePath;
    }
    
    public String readContentFromFile(String filePath) {
        Obj curr=root;
        String[] a=filePath.split("/");
        for(int i=1;i<a.length;i++){
            curr=curr.child.get(a[i]);
        }
        return curr.content.toString();
    }
    public void delete(String path) {
        Obj curr=root;
        String[] a=path.split("/");
        for(int i=1;i<a.length-1;i++){
            curr=curr.child.get(a[i]);
        }
        curr.child.remove(a[a.length-1]);
    }
}
package design_TextEditor;
import java.util.*;

public class TextPad {
	int maxWidth;
	List<String> content;
	Stack<Operation> undo;
	Stack<Operation> redo;
	int[] cursorLocation;
	String chipBoard;
	int[] selectedField;
	
	
	public TextPad(int maxWidth) {
		this.content=new ArrayList<String>();
		this.maxWidth = maxWidth;
		this.undo=new Stack<Operation>();
		this.redo=new Stack<Operation>();
		this.chipBoard="";
		this.selectedField=new int[]{-1,-1,-1,-1};
		this.cursorLocation=new int[]{0,0};
	}
	public boolean moveCursor(int r,int c){
		this.selectedField[0]=-1;
		if(r>=this.content.size()||c>this.content.get(r).length()){
			return false;
		}
		this.cursorLocation[0]=r;
		this.cursorLocation[1]=c;
		return true;
	}
	public void select(int r1,int c1,int r2,int c2){
		if(r2<r1){
			int temp=r2;
			r2=r1;
			r1=temp;
			temp=c2;
			c2=c1;
			c1=temp;
		}
		else if(r1==r2){
			this.selectedField=new int[]{r1,Math.min(c1, c2),r2,Math.max(c1, c2)};
			return;
		}
		this.selectedField=new int[]{r1,c1,r2,c2};
	}
	public void copyToChipBoard(){
		if(this.selectedField[0]==-1){
			this.chipBoard="";
			return;
		}
		StringBuilder sb=new StringBuilder();
		int[] curr=new int[]{this.selectedField[0],this.selectedField[1]};
		int rEnd=this.selectedField[2];
		int cEnd=this.selectedField[3];
		while(curr[0]<=rEnd){
			if(curr[0]==this.selectedField[0]&&curr[0]==rEnd){
				sb.append(this.content.get(curr[0]).substring(curr[1], cEnd));
			}
			else if(curr[0]==this.selectedField[0]){
				sb.append(this.content.get(curr[0]).substring(curr[1]));
			}
			else if(curr[0]==rEnd){
				sb.append(this.content.get(curr[0]).substring(curr[1],cEnd));
			}
			else{
				sb.append(this.content.get(curr[0]));
			}
			curr[0]++;
			curr[1]=0;
		}
	}
	public void deleteLetter(int i, int j) {
		this.undo.push(new DeleteLetter(i,j,this.content.get(i).charAt(j),this));
		String curr=this.content.get(i).substring(0, j)+this.content.get(i).substring(j+1);
		int r=i;
		while(r+1<this.content.size()&&curr.length()>0){
			curr=curr+this.content.get(r+1).charAt(0);
			this.content.set(r, curr);
			r++;
			curr=this.content.get(r).substring(1);
		}
		this.content.get(this.content.size()-1).equals("");
		this.content.remove(this.content.size()-1);
	}
	public void deleteLetter() {
		int i=this.cursorLocation[0];
		int j=this.cursorLocation[1];
		this.cursorLocation[1]--;
		while(this.cursorLocation[1]==0){
			this.cursorLocation[0]--;
			this.cursorLocation[1]=this.content.get(this.cursorLocation[0]).length();
		}
		this.undo.push(new DeleteLetter(i,j,this.content.get(i).charAt(j-1),this));
		String curr=this.content.get(i).substring(0, j-1)+this.content.get(i).substring(j);
		int r=i;
		while(r<this.content.size()){
			if(r+1<this.content.size()&&this.content.get(r+1).length()>0){
				this.content.set(r, curr+this.content.get(r+1).charAt(0));
				curr=this.content.get(r+1).substring(1);
			}
			else{
				this.content.set(r, curr);
				break;
			}
			r++;
		}
		if(this.content.get(this.content.size()-1).equals("")){
			this.content.remove(this.content.size()-1);
		}
	}

	public void addLetter(int i, int j, char ch) {
		this.undo.push(new AddLetter(i,j,ch,this));
		String curr=this.content.get(i).substring(0, j)+ch+this.content.get(i).substring(j);
		this.content.set(i, curr.substring(0, Math.min(curr.length(),this.maxWidth)));
		if(curr.length()<=maxWidth){
			return;
		}
		curr=curr.substring(this.maxWidth);
		int r=i+1;
		while(r<this.content.size()&&curr.length()>0){
			curr=curr+this.content.get(r);
			this.content.set(r, curr.substring(0, Math.min(curr.length(),this.maxWidth)));
			if(curr.length()<=maxWidth){
				return;
			}
			curr=curr.substring(this.maxWidth);
		}
		if(curr.length()>0){
			this.content.add(curr);
		}
	}
	public void addLetter(char ch) {
		int i=this.cursorLocation[0];
		int j=this.cursorLocation[1];
		if(i==this.content.size()){
			this.content.add("");
		}
		this.cursorLocation[1]++;
		if(this.cursorLocation[1]==this.maxWidth){
			this.cursorLocation[0]++;
			this.cursorLocation[1]=0;
		}
		this.undo.push(new AddLetter(i,j,ch,this));
		if(i==this.content.size()){
			this.content.add("");
		}
		String curr=this.content.get(i).substring(0, j)+ch+this.content.get(i).substring(j);
		this.content.set(i, curr.substring(0, Math.min(curr.length(),this.maxWidth)));
		if(curr.length()<=maxWidth){
			return;
		}
		curr=curr.substring(this.maxWidth);
		int r=i+1;
		while(r<this.content.size()&&curr.length()>0){
			curr=curr+this.content.get(r);
			this.content.set(r, curr.substring(0, Math.min(curr.length(),this.maxWidth)));
			if(curr.length()<=maxWidth){
				return;
			}
			curr=curr.substring(this.maxWidth);
		}
		if(curr.length()>0){
			this.content.add(curr);
		}
	}
}

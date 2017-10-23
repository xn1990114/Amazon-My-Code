package design_TextEditor;

public class DeleteLetter implements Operation{
	int[] location;
	char ch;
	TextPad pad;
	public DeleteLetter(int r,int c,char ch,TextPad pad){
		this.location=new int[]{r,c};
		this.ch=ch;
		this.pad=pad;
	}
	@Override
	public void reverseOperation() {
		this.pad.addLetter(location[0],location[1]-1,this.ch);
	}
}

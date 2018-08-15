package phone;
/*
 * phone:
实现一个encrypt function，可以把一个string里面的每个字符向后移动offset位.

s = 'fs', offset = 3, output = 'iv'

面试官的要求（问出来的）
string中不是字母的不要动
offset可以为负数，那就是向前移动

follow up:实现一个encrypt function，这次给一个段落paragraph,和一个offset. 
这个段落中的句子只可能以句号问好感叹号结尾，第一个句子需要用input给的offset去encrypt，
之后每个句子的用来encrypt的offset通过：
上一个句子的最后字符 - 这个句子的第一个字符 来决定。
面试官的要求：
要处理corner case,比如一个段落某些句子为空： I am happy!.how about you?
 */
public class ConvertWord {
	public String convertWord(String word,int offset){
		StringBuilder sb=new StringBuilder();
		offset=offset%26;
		if(offset<0){
			offset=offset+26;
		}
		for(int i=0;i<word.length();i++){
			char ch=word.charAt(i);
			if(ch>='a'&&ch<='z'){
				ch= (char)((ch-'a'+offset)%26+'a');
			}
			else if(ch>='A'&&ch<='Z'){
				ch= (char)((ch-'A'+offset)%26+'A');
			}
			sb.append(ch);
		}
		return sb.toString();
	}
	public String convertSentence(String s,int offset){
		StringBuilder sb=new StringBuilder();
		offset=simplifyOffset(offset);
		char last='.';
		int index=0;
		while(index<s.length()){
			int start=index;
			while(index<s.length()&&s.charAt(index)!='!'&&s.charAt(index)!='.'&&s.charAt(index)!='?'){
				index++;
			}
			// offset=0 if current or last have no letter;
			if(start<index&&last!='.'){
				char curr=s.charAt(index-1);
				offset=simplifyOffset(curr-last);
				last=curr;
			}
			else if(start==index){
				last='.';
			}
			else{
				last=s.charAt(index-1);
			}
			String part1=convertWord(s.substring(start,index),offset);
			sb.append(part1);
			sb.append(s.charAt(index));
			index++;
			offset=0;
		}
		return sb.toString();
	}
	public int simplifyOffset(int offset){
		offset=offset%26;
		if(offset<0){
			offset=offset+26;
		}
		return offset;
	}
}

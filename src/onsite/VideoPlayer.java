package onsite;
import java.util.*;
/*
 * 目就是实时获取video的popular程度和排名，需要实现三个函数, 
videoViewed(String videoId) - 观看video，每看一次view次数就会增加
getRanking(String video) 根据一个videoId，找到其排名，排名根据views的次数来排序
getTopVideos() - 得到前十排名

video大概数量为1 million，设计一个实现方案来存储和获取video，要求详细写明思考的过程，分析复杂度，必要时注释。
 */
public class VideoPlayer {
	class Node{
		int videoId;
		int feq;
		int rank;
		Node next;
		Node pre;
		public Node(int videoID){
			this.videoId=videoID;
			this.feq=0;
			this.rank=0;
		}public Node(int videoID,int feq){
			this.videoId=videoID;
			this.feq=feq;
			this.rank=0;
		}
	}
	public Map<Integer,String> videoMap;
	public Map<Integer,Node> nodeMap;
	public Node start;
	public Node end;
	public VideoPlayer(){
		this.videoMap=new HashMap<Integer,String>();
		this.nodeMap=new HashMap<Integer,Node>();
		this.start=new Node(-1,0);
		this.end=new Node(-1,Integer.MAX_VALUE);
		start.next=end;
		end.pre=start;
	}
	public void addVideo(int id,String name) throws Exception{
		if(this.videoMap.containsKey(id)){
			throw new Exception("Video id already exist, can't add");
		}
		this.videoMap.put(id, name);
		Node curr=new Node(id);
		this.nodeMap.put(id, curr);
		curr.rank=this.start.next.rank+1;
		curr.next=start.next;
		curr.next.pre=curr;
		curr.pre=start;
		start.next=curr;
	}
	public void vidoeViewed(int videoID) throws Exception{
		if(!this.videoMap.containsKey(videoID)){
			throw new Exception("Video doesn't exist");
		}
		Node curr=this.nodeMap.get(videoID);
		curr.next.pre=curr.pre;
		curr.pre.next=curr.next;
		curr.feq++;
		Node last=curr.pre;
		while(last.next!=end&&last.next.feq<curr.feq){
			last.next.rank++;
			curr.rank--;
			last=last.next;
		}
		curr.next=last.next;
		curr.next.pre=curr;
		last.next=curr;
		curr.pre=last;
	}
	public int getRanking(int videoID) throws Exception{
		if(!this.videoMap.containsKey(videoID)){
			throw new Exception("Video doesn't exist");
		}
		return this.nodeMap.get(videoID).rank;
	}
	public List<String> getTopVideos(){
		Node curr=end.pre;
		List<String> res=new ArrayList<String>();
		while(curr!=start&&res.size()<10){
			res.add("Rank "+curr.rank+" is: "+this.videoMap.get(curr.videoId)+ " with feq of: "+curr.feq);
			curr=curr.pre;
		}
		return res;
	}
}

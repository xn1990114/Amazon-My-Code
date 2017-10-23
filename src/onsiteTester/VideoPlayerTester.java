package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.VideoPlayer;

public class VideoPlayerTester {

	@Test
	public void test() throws Exception{
		VideoPlayer vp=new VideoPlayer();
		vp.addVideo(1, "Doctor Strange");vp.addVideo(2, "Harry Potter");
		vp.addVideo(3, "Pirates");vp.addVideo(4, "Star wars");
		vp.addVideo(5, "Splider man");vp.addVideo(6, "Dead pool");
		vp.addVideo(7, "KingsMan");vp.addVideo(8, "Cartoon");
		vp.addVideo(9, "Porn");vp.addVideo(10, "Transformer");
		vp.addVideo(11, "Boss baby");vp.addVideo(12, "Frozen");
		System.out.println(vp.nodeMap.size());
		for(int i=0;i<100;i++){
			vp.vidoeViewed((int)(Math.random()*12+1));
		}
		List<String> r1=vp.getTopVideos();
		for(String s:r1){
			System.out.println(s);
		}
		System.out.println(vp.getRanking(5));System.out.println(vp.getRanking(6));
		System.out.println(vp.getRanking(7));System.out.println(vp.getRanking(8));
		for(int i=0;i<100;i++){
			vp.vidoeViewed((int)(Math.random()*12+1));
		}
		List<String> r2=vp.getTopVideos();
		for(String s:r2){
			System.out.println(s);
		}
	}

}

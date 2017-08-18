package jukeBox;

import static org.junit.Assert.*;

import org.junit.Test;

public class JukeBoxTest {

	@Test
	public void test() {
		JukeBox jb=new JukeBox();
		Song xiaojiuwo=new Song("xiao jiu wo","someone");
		Song huasha=new Song("hua sha","jay");
		Song xiatian=new Song("xia tian","lin jun jie");
		assertTrue(jb.addNewSong(huasha));
		assertTrue(!jb.addNewSong(huasha));
		assertTrue(jb.addNewSong(xiatian));
		assertTrue(jb.addNewSong(xiaojiuwo));
		assertTrue(jb.memory.size()==3);
		assertTrue(jb.deleteSong("xiao jiu wo"));
		assertTrue(!jb.deleteSong("xiao jiu wo"));
		assertTrue(jb.memory.size()==2);
		jb.createNewList();
		jb.shuffleList();
		jb.playSongs();
		jb.addSongToList("xiao jiu wo");
		jb.playSongs();
		jb.addNewSong(xiaojiuwo);
		jb.addSongToList("xiao jiu wo");
		jb.playSongs();
	}

}

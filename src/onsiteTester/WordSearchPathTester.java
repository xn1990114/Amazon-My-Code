package onsiteTester;

import java.util.List;

import org.junit.Test;

import onsite.WordSearchPath;

public class WordSearchPathTester {

	@Test
	public void test1() {
		WordSearchPath tester=new WordSearchPath();
		char[][] board ={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		List<List<int[]>> res=tester.searchWordPath(board, "ABCCED");
		tester.printPath(res);
	}
	@Test
	public void test2() {
		WordSearchPath tester=new WordSearchPath();
		char[][] board ={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		List<List<int[]>> res=tester.searchWordPath(board, "ABCB");
		tester.printPath(res);
	}
	@Test
	public void test3() {
		WordSearchPath tester=new WordSearchPath();
		char[][] board ={
				{'A','B','C','E'},
				{'S','F','C','E'},
				{'A','D','B','S'}};
		List<List<int[]>> res=tester.searchWordPath(board, "BCE");
		tester.printPath(res);
	}

}

package design_jigsaw;

import static org.junit.Assert.*;

import org.junit.Test;

public class JigsawTester {

	@Test
	public void test() {
		Board board=new Board(50,200);
		board.startGame();
		System.out.println(board.pieceList.get(0).up==Edge.Flat);
		for(int i=0;i<board.content.length;i++){
			for(int j=0;j<board.content[0].length;j++){
				assertTrue(board.content[i][j]==null);
			}
		}
		Solver solver=new Solver(board);
		solver.solve();
		for(int i=0;i<board.content.length;i++){
			for(int j=0;j<board.content[0].length;j++){
				assertTrue(board.content[i][j]!=null);
				assertTrue(board.content[i][j].toString().equals(i+ " and "+ j));
				
			}
		}
	}

}

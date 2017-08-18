package jigsaw;

import java.util.*;

public class Solver {
	Board b;
	List<Piece> pieceList;

	public Solver(Board b) {
		this.b = b;
		this.pieceList = b.pieceList;
	}

	public void solve() {
		for (int i = 0; i < this.b.content.length; i++) {
			for (int j = 0; j < this.b.content[0].length; j++) {
				this.b.content[i][j] = findCorrectPiece(i, j);
			}
		}
	}

	public Piece findCorrectPiece(int row, int col) {
		int i = 0;
		while (i < this.pieceList.size()) {
			Piece p = this.pieceList.get(i);
			if (p.position[0] == row && p.position[1] == col) {
				this.pieceList.remove(i);
				return p;
			}
			i++;
		}
		return null;
	}
}

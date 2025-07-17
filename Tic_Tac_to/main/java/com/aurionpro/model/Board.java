package com.aurionpro.model;

public class Board {

	private Box[][] metrix = new Box[3][3];
	


	public void setMove(int row, int col, CharType charType) {
		metrix[row][col] = new Box(charType);
	}

	public boolean isEmpty(int row, int col) {
		if (metrix[row][col] == null)
			return true;
		return false;
	}

	public Box[][] getMetrix() {
		return metrix;
	}


	public boolean isWin(CharType ct) {
		return Utils.isWin(metrix,ct);
	}
	
	public void printBoard() {
	    // column header
	    System.out.println("    1   2   3");

	    for (int r = 0; r < 3; r++) {
	        // top border of the row
	        System.out.println("  +---+---+---+");

	        // row label, then each cell
	        System.out.print((r + 1) + " |");
	        for (int c = 0; c < 3; c++) {
	            CharType ct = (metrix[r][c] == null) 
	                          ? null 
	                          : metrix[r][c].getCharType();
	            System.out.print(" " + (ct == null ? " " : ct) + " |");
	        }
	        System.out.println();
	    }
	    // bottom border
	    System.out.println("  +---+---+---+");
	}


}

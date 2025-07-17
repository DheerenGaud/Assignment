package com.aurionpro.model;

public class Utils {

	public static boolean isLine(Box[][] metrix, int r1, int c1, int r2, int c2, int r3, int c3, CharType ct) {
		return metrix[r1][c1] != null && metrix[r2][c2] != null && metrix[r3][c3] != null
				&& metrix[r1][c1].getCharType() == ct && metrix[r2][c2].getCharType() == ct
				&& metrix[r3][c3].getCharType() == ct;
	}

	public static boolean isWin(Box[][] metrix, CharType ct) {
		if (Utils.isLine(metrix, 0, 0, 0, 1, 0, 2, ct))
			return true;
		if (Utils.isLine(metrix, 1, 0, 1, 1, 1, 2, ct))
			return true;
		if (Utils.isLine(metrix, 2, 0, 2, 1, 2, 2, ct))
			return true;

		if (Utils.isLine(metrix, 0, 0, 1, 0, 2, 0, ct))
			return true;
		if (Utils.isLine(metrix, 0, 1, 1, 1, 2, 1, ct))
			return true;
		if (Utils.isLine(metrix, 0, 2, 1, 2, 2, 2, ct))
			return true;

		// diagonals
		if (Utils.isLine(metrix, 0, 0, 1, 1, 2, 2, ct))
			return true;
		if (Utils.isLine(metrix, 0, 2, 1, 1, 2, 0, ct))
			return true;

		return false;
	}

}

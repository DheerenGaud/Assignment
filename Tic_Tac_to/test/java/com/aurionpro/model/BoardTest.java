package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class BoardTest {
	Board board;

	@BeforeEach
	void init() {
		this.board = new Board();
	}

	@Test
	void isShellEmpty() {
		assertEquals(true, board.isEmpty(0, 0));
	}

	@ParameterizedTest
	@EnumSource(CharType.class) // runs once for X and once for O
	void setMove_storesGivenMark(CharType mark) {
		board.setMove(2, 2, mark); 

		assertFalse(board.isEmpty(2, 2)); 
		assertEquals(mark, board.getMetrix()[2][2].getCharType());
	}
	
	

}

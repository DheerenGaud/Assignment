package com.aurionpro.model;

import java.util.Scanner;

public class GameManager {
   private  Board board;
   private  Player player1;
   private  Player player2;
    
   private  int turnCount = 0; 
   private  Player currentPlayerTurn;
    
    
	public GameManager( Player player1, Player player2 ) {
		board = new Board();
		this.player1= player1;
		this.player2 = player2;
		currentPlayerTurn = player1;
	}
	

	public void startGame(Scanner scanner) {

	    while (turnCount < 9) {
	    	System.out.println();
	    	System.out.println();

	    	board.printBoard(); 
	    	System.out.println();
	    	System.out.println("TURN  -> "+currentPlayerTurn.getName() + "  Symbol -> ("+ currentPlayerTurn.getCharType()+")");
	        System.out.printf("Enter row,col | eg. 1,2 \n");

	        String raw = scanner.next().trim();   
	        String[] tokens = raw.split("\\s*,\\s*");  
	        if (tokens.length != 2) {
	        	System.out.println();
	            System.out.println("Format should be row,col try again.");
	            continue;               
	        }

	        int row, col;
	        try {
	            row = Integer.parseInt(tokens[0]) - 1; 
	            col = Integer.parseInt(tokens[1]) - 1;
	        } catch (NumberFormatException ex) {
	        	System.out.println();
	            System.out.println("Row and column must be numbers 1-3.");
	            continue;
	        }

	        if (row < 0 || row > 2 || col < 0 || col > 2) {
	        	System.out.println();
	            System.out.println("Row/col out of range");
	            continue;
	        }
	        if (!board.isEmpty(row, col)) {
	        	System.out.println();
	            System.out.println("That square is already taken. Pick another.");
	            continue;
	        }

	        board.setMove(row, col, currentPlayerTurn.getCharType());
	        turnCount++;

	       
	                  

	       
	        if (turnCount>=5&&board.isWin(currentPlayerTurn.getCharType())) {
	        	board.printBoard();   
	        	System.out.println();
	            System.out.printf(currentPlayerTurn.getName()+" WIN !!!!!");
	            return;             
	        }

	        currentPlayerTurn = (currentPlayerTurn == player1) ? player2 : player1;
	    }
	    board.printBoard();   
    	System.out.println();
	    System.out.println("Game draw.");
	}
	
	
}

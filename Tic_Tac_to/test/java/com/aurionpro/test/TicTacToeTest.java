package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.aurionpro.model.CharType;
import com.aurionpro.model.GameManager;
import com.aurionpro.model.Player;

public class TicTacToeTest {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Dheeren TicTacToe Game");
	    gameStart();
	}

	private static void gameStart() {
		Scanner scanner = new Scanner(System.in);
		List<CharType> taken = new ArrayList<>();
		
		Player player1 = createPlayer(scanner, taken);
		System.out.println();
		Player player2 = createPlayer(scanner, taken);
		
		GameManager gameManager = new GameManager(player1, player2);
		gameManager.startGame(scanner);
	}

	private static Player createPlayer(Scanner scanner, List<CharType> taken) {
		System.out.println();
	    System.out.print((taken.size()+1)+") Enter player name  : ");
	    String name = scanner.nextLine().trim();


	    CharType chosen;

	    if (taken.isEmpty()) {
	        while (true) {
	            System.out.print("Choose your mark (X / O): ");
	            String input = scanner.nextLine().trim().toUpperCase();

	            try {
	                chosen = CharType.valueOf(input);
	                if (taken.contains(chosen)) {
	                	System.out.println();
	                    System.out.println("That mark is already taken. Try again.");
	                } else {
	                    break;
	                }
	            } catch (IllegalArgumentException ex) {
	            	System.out.println();
	                System.out.println("Invalid choice. Please enter X or O.");
	            }
	        }
	    } else {
	        chosen = (taken.get(0) == CharType.X) ? CharType.O : CharType.X;
	    }

	    taken.add(chosen);
	    return new Player(name, chosen);
	}




}

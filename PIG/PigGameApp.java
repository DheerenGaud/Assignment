package com.aurionpro.conditinal.homework;

import java.util.Scanner;

public class PigGameApp {
	
	public static void playGame() {
		Scanner scanner = new Scanner(System.in);

		int turn = 1, score = 0;
		String s = new String();
		

		while (turn <= 5) {

			while (true) {
				System.out.print("Roll or hold? (r/h): ");
				String input = scanner.next().toLowerCase();
				if (input.equals("r")) {
					int dice = (int) (Math.random() * 6) + 1;
					System.out.println("Die : " + dice);
					if (dice == 1) {
						score = 0;
						break;
					} 
						
					score = score + dice;
                    continue;
				}
				
				if(input.equals("h")) {
						break;
				}
				
				System.out.print("Invalid input ");
				return;				
			}
			System.out.println("Total Score : " + score);
			if (score >= 20) {
				System.out.println("You finished in " + turn + " turns");
				break;
			}
			turn++;
			System.out.println("Current turn: " + turn);
			
		}
	}
	public static void startGame() {
		Scanner scanner = new Scanner(System.in);

		int turn = 1, score = 0;

		while (turn <= 5) {

			score = compleOneTurn(score,scanner);
			
			if(score==-1) {
				return;
			}
			
			System.out.println("Total Score : " + score);
			if (score >= 20) {
				System.out.println("You finished in " + turn + " turns");
				break;
			}
			turn++;
			System.out.println("Current turn: " + turn);
			
		}
	}
	private static int compleOneTurn(int score ,Scanner scanner) {
		while (true) {
			System.out.print("Roll or hold? (r/h): ");
			String input = scanner.next().toLowerCase();
			
			if (input.equals("r")) {
				int dice = (int) (Math.random() * 6) + 1;
				System.out.println("Die : " + dice);
				if (dice == 1) {
					return 0;
				} 
					
				score = score + dice;
                continue;
			}
			
			if(input.equals("h")) {
				return score;
			}
			
			System.out.print("Invalid input ");
			return -1;				
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is Pig Game ");
		startGame();
		
		System.out.println("Game Over");

	}

}

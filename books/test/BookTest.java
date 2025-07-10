package com.aurionpro.books.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.books.model.Book;
import com.aurionpro.books.model.SortByAuthor;
import com.aurionpro.books.model.SortByTitle;

public class BookTest {
	private static List<Book> bookList = new ArrayList<Book>();
	static int totalAvailableBook = 0;

	public static void main(String[] args) {
		System.out.println("Welocome to DHeeren Book Galary !!!");
		Scanner scanner = new Scanner(System.in);
		showMenu(scanner);

	}

	private static void showMenu(Scanner scanner) {

		while (true) {

			displayMenu();
			try {
				int input = scanner.nextInt();
				switch (input) {
				case 1:
					addNewBook(scanner);
					break;
				case 2:
					tryIssueBook(scanner);
					break;
				case 3:
					displayAvailableBooks();
					break;
				case 4:
					dislayIssuedBooks();
					break;
				case 5:
					tryReturnBook(scanner);
					break;
				case 6:
					Collections.sort(bookList, new SortByTitle());
					showAllBook();
					break;
				case 7:
					Collections.sort(bookList, new SortByAuthor());
					showAllBook();
					break;
				case 8:
					System.out.println("Exiting...");
					scanner.close();
					return;
				default:
					System.out.println("INVALID INPUT !!!");
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return;
			}

		}
	}

	private static void showAllBook() {
	  System.out.println();
		for(Book book : bookList) {
			System.out.println(book);
		}
	}

	private static void tryReturnBook(Scanner scanner) {
		if(totalAvailableBook==bookList.size()) {
			System.out.println("No book Issued");
			return ;
		}
		System.out.println("Returning Book");
		System.out.println();
		System.out.println("Select one Sr. ");
		dislayIssuedBooks();

		try {
			int input = scanner.nextInt();
			if (input > bookList.size() - totalAvailableBook) {
				System.out.println("Wrong Input");
				return;
			}
			returnBook(input);
			System.out.println();
			System.out.println("Book Succfully Returned");
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void returnBook(int input) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).isIssue()) {
				input--;
			}
			if (input == 0) {
				totalAvailableBook++;
				bookList.get(i).setIssue(false);
				return;
			}
		}
	}

	private static void tryIssueBook(Scanner scanner) {
		if(totalAvailableBook==0) {
			System.out.println("No book Available");
			return ;
		}
		System.out.println("Issueing Book");
		displayAvailableBooks();
		System.out.println("\n Enter The Book Id");
		try {
			String input = scanner.next();
//			if(input>totalAvailableBook) {
//				System.out.println("Wrong Input");
//				return;
//			}
			// issueBook(input);
			issueBookByID(input);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void issueBookByID(String input) {
		for (Book book : bookList) {
			if (!book.isIssue() && book.getBookId().equals(input)) {
				totalAvailableBook--;
				book.setIssue(true);
				System.out.println();
				System.out.println("Book Succfully Issued");
				System.out.println();
				return;
			}
		}
		System.out.println();
		System.out.println("BOOK NOT FOUND WITH THIS ID...");
		System.out.println();
	}

	private static void issueBook(int input) {
		for (int i = 0; i < bookList.size(); i++) {
			if (!bookList.get(i).isIssue()) {
				input--;
			}
			if (input == 0) {
				totalAvailableBook--;
				bookList.get(i).setIssue(true);
				return;
			}
		}
	}

	private static void dislayIssuedBooks() {
		int i = 1;
		System.out.println("ALL ISSUED BOOKS");
		for (Book book : bookList) {
			if (book.isIssue()) {
				System.out.println(" " + i + ">" + " " + book.getTitle());
				i++;
			}
		}

	}

	private static void displayAvailableBooks() {
		int i = 1;
		System.out.println("ALL AVAILABLE BOOKS");
		for (Book book : bookList) {
			if (!book.isIssue()) {
				System.out.println(" " + i + ">" + " " + book.getTitle() + " Id :" + book.getBookId());
				i++;
			}
		}
	}

	private static void addNewBook(Scanner scanner) {

		System.out.println("Enter Book Detail");
		System.out.println("Title : ");
		String title = scanner.next();
		System.out.println("Author : ");
		String author = scanner.next();
		String bookId = createBookId();

		Book book = new Book(title, bookId, author);
		System.out.println(book);
		totalAvailableBook++;
		bookList.add(book);

	}

	private static String createBookId() {
		int randomNumber = (int) (Math.random() * 1000);
		return String.format("BK-%03d", randomNumber);
	}

	private static void displayMenu() {
		System.out.println();
		System.out.println(" 1> Add New Book");
		System.out.println(" 2> Issue Book by Id");
		System.out.println(" 3> Dispaly All Available Books");
		System.out.println(" 4> Dispaly All Issued Books");
		System.out.println(" 5> Return Book");
		System.out.println(" 6> Sort Books By Title");
		System.out.println(" 7> Sort Books By Author");
		System.out.println(" 8> Exit");
		System.out.println();
	}

}

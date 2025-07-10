package com.aurionpro.books.model;

public class Book {
	private String title;
	private String bookId;
	private boolean isIssue;
	private String author;
	
	public Book(String title, String bookId, String author) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.isIssue = false;
		this.author = author;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public boolean isIssue() {
		return isIssue;
	}

	public void setIssue(boolean isIssue) {
		this.isIssue = isIssue;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	@Override
	public String toString() {
	    return
	           "  Title     : " + title +"\n" +
	           "  Book ID   : " + bookId + "\n" +
	           "  Is Issued : " + isIssue + "\n" +
	           "  Author    : " + author+ "\n\n";
	          
	}


	
}

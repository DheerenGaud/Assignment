package com.aurionpro.exceptions;

public class ItemExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemExistException(String name) {
		super("Item already exists: " + name);
	}

	public ItemExistException() {
		super("Item already exists.");
	}
}

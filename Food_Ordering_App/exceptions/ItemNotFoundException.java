package com.aurionpro.exceptions;

public class ItemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

   
    public ItemNotFoundException(String name) {
        super("Requested item is not present : Your Request : " +name);
    }
    public ItemNotFoundException() {
        super("Requested item is not present");
    }
}

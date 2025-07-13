package com.aurionpro.exceptions;

public class PaymentExceptions extends RuntimeException {
    public PaymentExceptions(String message) {
        super("Payment Exception: " + message);
    }
}

package com.aurionpro.payment.model;



public interface Payment {
	
	boolean pay(int ammount);
    boolean validateDetails(PaymentDetails details);

}

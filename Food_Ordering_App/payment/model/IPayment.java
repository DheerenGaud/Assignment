package com.aurionpro.payment.model;

import java.util.Scanner;

public interface IPayment {
	
	boolean pay(double ammount);
	String getPayMethodName();
    boolean validateDetails();
    void collectDetails(Scanner in);
   

}

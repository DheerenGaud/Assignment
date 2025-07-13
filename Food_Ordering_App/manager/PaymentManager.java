package com.aurionpro.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.aurionpro.exceptions.InvalidInputException;
import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.payment.methods.Debit;
import com.aurionpro.payment.methods.Paypal;
import com.aurionpro.payment.methods.UPI;
import com.aurionpro.payment.model.IPayment;

public class PaymentManager {

	private static Map<String, IPayment> pyamnetMap;
	private static Map<String, IPayment> notApprovePaymnetMap;

	public PaymentManager() {
		pyamnetMap = new HashMap<>();
		notApprovePaymnetMap = new HashMap<>();
		pyamnetMap.put("debit", new Debit());
		pyamnetMap.put("paypal", new Paypal());
		
		notApprovePaymnetMap.put("upi", new UPI());
	}
	
	public void addNewPayment(String payment) {
		if(notApprovePaymnetMap.containsKey(payment)) {
			pyamnetMap.put(payment, notApprovePaymnetMap.get(payment));
			notApprovePaymnetMap.remove(payment);
			return ;
		}
		
		throw new InvalidInputException(payment);
	}

	public void removePayment( String payment) {
		System.out.println(payment);
		if(pyamnetMap.containsKey(payment)) {
			notApprovePaymnetMap.put(payment, pyamnetMap.get(payment));
			pyamnetMap.remove(payment);
			return;
		}
		throw new InvalidInputException(payment);
	}

	public boolean  showNotApprovePaymnetMathod() {
		if(notApprovePaymnetMap.size()==0) {
			System.out.println("No Paymet Found");
			return false;
		}
		for (Entry<String, IPayment> entry : notApprovePaymnetMap.entrySet()) {
			System.out.println("-> "+entry.getKey());
		}
		return true;
	}
	
	public boolean  showAllPaymentMathod() {
		if(pyamnetMap.size()==0) {
			System.out.println("No Paymet Found");
			return false;
		}
		for (Entry<String, IPayment> entry : pyamnetMap.entrySet()) {
			System.out.println("-> "+entry.getKey());
		}
		return true;
	}
	
	
	public static IPayment getPaymentMethod(String paymentMthod) {
		if (!pyamnetMap.containsKey(paymentMthod)) {
			throw new ItemNotFoundException(paymentMthod);
    	}
		
			return pyamnetMap.get(paymentMthod);

		
	}
	
	 public static  boolean paymentProcess(IPayment paymentMethod,double amount) {
		   if(paymentMethod.validateDetails()) {
			   return  paymentMethod.pay(amount);
		   }
		   return false;
	   }

}

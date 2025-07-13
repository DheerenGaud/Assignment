package com.aurionpro.discount.types;

import com.aurionpro.discount.model.IDiscount;

public class Discount_01  implements IDiscount{

	
	public double getHittingAmount() {
		return 500;
	}

	
	public double getDiscountParcent() {
		return 5;
	}

}

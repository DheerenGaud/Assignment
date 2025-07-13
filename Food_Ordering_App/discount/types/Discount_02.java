package com.aurionpro.discount.types;

import com.aurionpro.discount.model.IDiscount;

public class Discount_02  implements IDiscount{

	
	public double  getHittingAmount() {
		return 1500;
	}

	
	public double getDiscountParcent() {
		return 15;
	}

}

package com.code.enums;

public enum Plan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private double price;
	private Plan(double price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

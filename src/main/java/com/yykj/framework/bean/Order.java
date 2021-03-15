package com.yykj.framework.bean;

public class Order {
	
	private String name = "";
	
	private double price = 0.0;
	
	private int amount = 0;
	
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}


	public Order(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
}

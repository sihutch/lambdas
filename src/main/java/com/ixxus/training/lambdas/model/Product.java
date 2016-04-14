package com.ixxus.training.lambdas.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
	
	public static final List<Product> PRODUCT_LIST = new ArrayList<>();
	
	static {
		PRODUCT_LIST.add(new Product("Shoes", new BigDecimal("40.50")));
		PRODUCT_LIST.add(new Product("Tea", new BigDecimal("2.00")));
		PRODUCT_LIST.add(new Product("Apples", new BigDecimal("1.50")));
		PRODUCT_LIST.add(new Product("Oranges", new BigDecimal("2.00")));
		PRODUCT_LIST.add(new Product("Grapes", new BigDecimal("2.00")));
		PRODUCT_LIST.add(new Product("DVD", new BigDecimal("10.00")));
	}
	
	private String name;
	private BigDecimal price;

	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
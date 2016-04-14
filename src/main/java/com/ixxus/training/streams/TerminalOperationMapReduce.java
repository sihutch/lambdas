package com.ixxus.training.streams;

import java.math.BigDecimal;

import static com.ixxus.training.lambdas.model.Product.*;

public class TerminalOperationMapReduce {

	public static void main(String[] args) {
		maximumPrice();
		maximumPriceBelow(new BigDecimal("40.00"));
	}

	private static void maximumPrice() {
		System.out.println(
				PRODUCT_LIST.stream()
						.map(p -> p.getPrice())
						.max(BigDecimal::compareTo));
	}

	private static void maximumPriceBelow(BigDecimal lowest) {
		System.out.println(
				PRODUCT_LIST.stream()
						.map(p -> p.getPrice())
						.filter(p -> p.compareTo(lowest) == -1)
						.max(BigDecimal::compareTo));
	}

}
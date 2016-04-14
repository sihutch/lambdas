package com.ixxus.training.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ixxus.training.lambdas.model.Product;

public class TerminalOperationCollect {

	public static void main(String[] args) {
		basicToList();
		mergeListToMap();
	}

	private static void basicToList() {
		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> integers = ints.stream()
				.filter(i -> i > 5)
				.collect(Collectors.toList());

		System.out.println("toList: " + integers);
	}

	private static void mergeListToMap() {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("Apples", new BigDecimal("1.99")));
		productList.add(new Product("Apples", new BigDecimal("1.99")));
		productList.add(new Product("Oranges", new BigDecimal("2.99")));
		productList.add(new Product("Oranges", new BigDecimal("2.99")));

		System.out.println("mergeListToMap:" +
				productList.stream()
						.collect(Collectors.toMap(
								p -> p.getName(), // Key mapper
								p -> p.getPrice(), // value mapper
								BigDecimal::add))); // mergeFunction
	}
}
package com.ixxus.training.streams;

import static com.ixxus.training.lambdas.model.Product.PRODUCT_LIST;
import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ixxus.training.lambdas.model.Product;

public class IntermediateOperationSorted {
	public static void main(String[] args) {
		naturalOrder();
		naturalOrderRequiresComparable();
		reversalWithComparator();
		multipleFluentComparisonUsingComparing();
	}

	private static void naturalOrder() {
		List<Integer> ints = Arrays.asList(3, 1, 12, 444, 2, 55, 9, 2345);
		System.out.println("Natural sort: " +
				ints.stream()
						.sorted()
						.collect(Collectors.toList()));
	}

	private static void naturalOrderRequiresComparable() {
		try {
			PRODUCT_LIST.stream()
					.sorted()
					.collect(Collectors.toList());
		} catch (ClassCastException e) {
			//Expected -  to show that Comparable is required
			System.out.println("naturalOrderRequiresComparable" + e.getMessage());
		}
	}

	private static void reversalWithComparator() {
		Comparator<Integer> ascending = (x, y) -> x.compareTo(y);
		Comparator<Integer> descending = ascending.reversed();

		List<Integer> ints = Arrays.asList(3, 1, 12, 444, 2, 55, 9, 2345);
		System.out.println("Ascending sort: " +
				ints.stream()
						.sorted(ascending)
						.collect(Collectors.toList()));

		System.out.println("Descending sort: " +
				ints.stream()
						.sorted(descending)
						.collect(Collectors.toList()));
	}

	// Uses the higher-order function comparing (static) on Comparator
	private static void multipleFluentComparisonUsingComparing() {
		Function<Product, BigDecimal> byPrice = product -> product.getPrice();
		Function<Product, String> byName = product -> product.getName();
		System.out.println("byPrice then by Name: " +
				PRODUCT_LIST.stream()
						.sorted(comparing(byPrice).thenComparing(byName))
						.collect(Collectors.toList()));
	}
}
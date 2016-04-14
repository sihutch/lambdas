package com.ixxus.training.streams;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import com.ixxus.training.lambdas.model.Product;

public class NewMapMethods {

	private static final BigDecimal TWO = new BigDecimal("2");

	public static void main(String[] args) {
		doublePricesWithReplaceAll();
		computeANewPriceForNike();
		mergePricesForProduct();
	}

	private static void doublePricesWithReplaceAll() {
		Map<String, Product> shoeMap = new HashMap<>();
		shoeMap.put("1", new Product("nike", new BigDecimal("99.99")));
		shoeMap.put("2", new Product("addidas", new BigDecimal("50.99")));
		shoeMap.put("3", new Product("reebok", new BigDecimal("50.99")));

		System.out.println("doublePricesWithReplaceAll (before): " + shoeMap);
		
		shoeMap.replaceAll((k, v) -> new Product(v.getName(), v.getPrice().multiply(TWO)));
		
		System.out.println("doublePricesWithReplaceAll (after): " + shoeMap);

	}

	private static void computeANewPriceForNike() {
		Map<String, Product> shoeMap = new HashMap<>();
		shoeMap.put("1", new Product("nike", new BigDecimal("99.99")));
		shoeMap.put("2", new Product("addidas", new BigDecimal("50.99")));
		shoeMap.put("3", new Product("reebok", new BigDecimal("50.99")));

		BiFunction<String, Product, Product> doublePriceIfNikeElseRemove = (k, v) -> v.getName().equals("nike")
				? new Product(v.getName(), v.getPrice().multiply(TWO))
				: null;
				
		shoeMap.compute("1", doublePriceIfNikeElseRemove);
		shoeMap.compute("2", doublePriceIfNikeElseRemove);
		
		System.out.println("computeANewPriceForNike: " + shoeMap);
	}
	
	private static void mergePricesForProduct() {
		Map<String, BigDecimal> totalPricePerBrandMap = new HashMap<>();
		totalPricePerBrandMap.put("nike", new BigDecimal("99.99"));
		totalPricePerBrandMap.put("addidas", new BigDecimal("50.99"));
				
		//Total price is increased for nike
		totalPricePerBrandMap.merge("nike", new BigDecimal("100.00"), BigDecimal::add);
		//The new balance entry is added to the map
		totalPricePerBrandMap.merge("new balance", new BigDecimal("45.00"), BigDecimal::add);
		//The addidas entry is removed as function returns null
		totalPricePerBrandMap.merge("addidas", new BigDecimal("45.00"), (p1, p2) -> {return null;});
		
		System.out.println("mergePricesForProduct: " + totalPricePerBrandMap);
	}
}
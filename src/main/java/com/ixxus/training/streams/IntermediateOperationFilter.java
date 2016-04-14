package com.ixxus.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationFilter {
		
	private static final List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	public static void main(String[] args) {
		filterGt3();
		filterGt3AndEven();
	}
	
	private static void filterGt3() {
		System.out.println("filterGt3:" +
		ints.stream()
			.filter(i -> i >=3)
			.collect(Collectors.toList())
		);
	}
	
	//Which of these is easier to read and understand
	private static void filterGt3AndEven() {
		System.out.println("filterGt3AndEven:" +
		ints.stream()
			.filter(i -> i >=3)
			.filter(i -> i % 2 == 0)
			.collect(Collectors.toList())
		);
		
		System.out.println("filterGt3AndEven - single filter:" +
				ints.stream()
					.filter(i -> i >=3 && i % 2 == 0)
					.collect(Collectors.toList())
				);
	}
}
package com.ixxus.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationMap {
		
	private static final List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	public static void main(String[] args) {
		mapIntToString();
	}
	
	private static void mapIntToString() {
		System.out.println("mapIntToString:" +
		ints.stream()
			.map(i -> "Number" + i)
			.collect(Collectors.toList())
		);
	}
	
	
}
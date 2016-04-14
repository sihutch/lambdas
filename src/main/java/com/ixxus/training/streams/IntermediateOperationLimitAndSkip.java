package com.ixxus.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationLimitAndSkip {
	
	List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	public static void main(String[] args) {
		IntermediateOperationLimitAndSkip is = new IntermediateOperationLimitAndSkip();
		is.skipInts(5);
		is.limitInts(5);
		is.skipAndLimit(5, 2);
		is.limitAndSkip(5, 2);
	}
	
	private void skipInts(long n) {
		System.out.println("skipInts("+n+"): " +
				ints.stream()
				.skip(n)
				.collect(Collectors.toList()));
	}
	
	private void limitInts(long n) {
		System.out.println("limitInts("+n+"): " +
				ints.stream()
				.limit(n)
				.collect(Collectors.toList()));
	}
	
	private void skipAndLimit(long skipN, long limitN) {
		System.out.println("skipAndLimit(skip:"+skipN+", limit:"+limitN+"): " +
				ints.stream()
				.skip(skipN)
				.limit(limitN)
				.collect(Collectors.toList()));
	}
	
	private void limitAndSkip(long limitN,long skipN) {
		System.out.println("limitAndSkip(limit:"+limitN+", skipe:"+skipN+"): " +
				ints.stream()
				.limit(limitN)
				.skip(skipN)
				.collect(Collectors.toList()));
	}
}
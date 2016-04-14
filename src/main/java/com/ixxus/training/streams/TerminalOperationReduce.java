package com.ixxus.training.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class TerminalOperationReduce {

	static List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	static List<Integer> emptyList = Collections.emptyList();

	public static void main(String[] args) {
		maxReduceWithIdentityAndAccumulator(ints);
		reduceWithIdentityAndAccumulatorEquivalent(ints,0, Integer::max);
		
		maxReduceWithAccumulator(emptyList);
		reduceWithAccumulatorEquivalent(ints,Integer::max);
		
		averageStringLength();
	}

	private static void maxReduceWithIdentityAndAccumulator(List<Integer> ls) {
		System.out.println("maxReduceWithIdentityAndAccumulator: " +
				ls.stream().reduce(0, Integer::max));
	}

	private static void reduceWithIdentityAndAccumulatorEquivalent(List<Integer> ls,Integer identity, BinaryOperator<Integer> accumulator) {
		Integer result = identity;
		for (Integer i : ls) {
			result = accumulator.apply(result, i);
		}

		System.out.println("reduceWithIdentityAndAccumulatorEquivalent: " + result);
	}

	private static void maxReduceWithAccumulator(List<Integer> ls) {
		System.out.println("maxReduceWithAccumulator: " +
				ls.stream().reduce(Integer::max));
	}

	private static void reduceWithAccumulatorEquivalent(List<Integer> ls,BinaryOperator<Integer> accumulator) {
		boolean foundAny = false;
		Integer result = null;
		for (Integer i : ls) {
			if (!foundAny) {
				foundAny = true;
				result = i;
			} else
				result = accumulator.apply(result, i);
		}
		Optional<Integer> optResult = foundAny ? Optional.of(result) : Optional.empty();
		System.out.println("reduceWithAccumulatorEquivalent: " + optResult);
	}
	
	
	private static void averageStringLength() {
		List<String> ls = Arrays.asList("one", "two", "three", "four", "five");
		System.out.println("averageStringLength: " +
				ls.stream()
				  .mapToInt(String::length)
				  .average());
	}
}
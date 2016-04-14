package com.ixxus.training.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {

	public static void main(String[] args) {
		getPrimes(0, 10);
	}

	/**
	 * @param fromNum
	 * @param count
	 * @return count prime numbers starting at fromNum
	 */
	public static List<Integer> getPrimes(int fromNum, int count) {
		return Stream.iterate(getNextPrime(fromNum - 1), i -> getNextPrime(i))
				.peek(System.out::println)
				.limit(count) // Comment out the limit to show this is infinite
				.collect(Collectors.toList());
	}

	public static int getNextPrime(int i) {
		int nextNum = i + 1;
		if (isPrimeNumber(nextNum)) {
			return nextNum;
		} else {
			return getNextPrime(nextNum);
		}
	}

	public static boolean isPrimeNumber(int i) {
		return i > 1 && IntStream
						.rangeClosed(2, (int) Math.sqrt(i))
						.noneMatch(d -> i % d == 0);
	}
}
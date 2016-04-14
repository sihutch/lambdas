package com.ixxus.training.streams;

import java.util.List;
import java.util.stream.Collectors;
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
	public static List<Integer> getPrimes (int fromNum, int count ) {
		return Stream.iterate(getNextPrime(fromNum -1), i -> getNextPrime(i))
				     .peek(System.out::println)
				     .limit(count) //Comment out the limit to show this is infinite
				     .collect(Collectors.toList());
	}
	
	public static int getNextPrime(int i) {
		if (isPrimeNumber(i + 1)) {
			return i + 1;
		} else {
			return getNextPrime(i + 1);
		}
	}

	public static boolean isPrimeNumber(int i) {
		if (i < 2) {
			return false;
		}
		for (int d = 2; d <= (int) Math.sqrt(i); d++) {
			if (i % d == 0) {
				return false;
			}
		}
		return true;
	}
}
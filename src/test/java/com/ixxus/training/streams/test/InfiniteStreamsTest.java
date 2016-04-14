package com.ixxus.training.streams.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.ixxus.training.streams.InfiniteStreams;

public class InfiniteStreamsTest {
	
	private static int[] EXPECTED_PRIMES = {2,3,5,7,11,13,17,19,23,29};
	private static int[] NON_PRIMES = {1,4,6,8,9,10,12,14,15,16,18,20,21,22};
	
	@Test
	public void isPrimeNumber() {
		for(int i: EXPECTED_PRIMES) {
			assertThat(i + " is prime",  InfiniteStreams.isPrimeNumber(i), equalTo(true));
		}
 	}
	
	@Test
	public void isNotPrimeNumber() {
		for(int i: NON_PRIMES) {
			assertThat(i + " is not prime", InfiniteStreams.isPrimeNumber(i), equalTo(false));
		}
 	}
}
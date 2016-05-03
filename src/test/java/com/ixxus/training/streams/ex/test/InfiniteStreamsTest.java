package com.ixxus.training.streams.ex.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ixxus.training.streams.ex.InfiniteStreams;

public class InfiniteStreamsTest {
	
	private static List<Integer> EXPECTED_PRIMES = Arrays.asList(2,3,5,7,11,13,17,19,23,29);
	private static List<Integer> NON_PRIMES = Arrays.asList(1,4,6,8,9,10,12,14,15,16,18,20,21,22);
	
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
	
	@Test
	public void nextPrimeFromAGivenNumber() {
		for(int i =0; i<EXPECTED_PRIMES.size()-1 ;i++) {
			int num = EXPECTED_PRIMES.get(i);
			int expectedNextPrime = EXPECTED_PRIMES.get(i+1);
			assertThat("Next prime is incorrect", InfiniteStreams.getNextPrime(num), equalTo(expectedNextPrime));
		}
 	}
	
	@Test
	public void theRequestedNumberOfPrimesAreReturnedInOrder() {
		assertThat("Primes not returned as expected", InfiniteStreams.getPrimes(1, 10), equalTo(EXPECTED_PRIMES));
	}
}
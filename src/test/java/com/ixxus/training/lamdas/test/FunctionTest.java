package com.ixxus.training.lamdas.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.function.Function;

import org.junit.Test;

public class FunctionTest {
	
	Function<String, Integer> lengthOfString = s -> s.length();
	Function<Integer, String> squareIntAsString = i -> String.valueOf(i * i);
	
	@Test
	public void applyExecutesAFunction() {
		assertThat(lengthOfString.apply("foo"), equalTo(3));
	}
	
	@Test
	public void andThenRunsAfterTheFunctionIsApplied() {
		assertThat(lengthOfString.andThen(squareIntAsString).apply("foo"), equalTo("9"));
	}
	
	@Test
	public void composeRunsBeforeTheFunctionIsApplied() {
		assertThat(lengthOfString.compose(squareIntAsString).apply(9), equalTo(2));
	}
	
}
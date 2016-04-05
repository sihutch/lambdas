package com.ixxus.training.lamdas.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.function.Predicate;

import org.junit.Test;

public class PredicateTest {
	
	Predicate<Integer> greaterThan3 = x -> x > 3;
	
	@Test
	public void standardPredicate() {
		assertThat(greaterThan3.test(4), equalTo(true));
		assertThat(greaterThan3.test(3), equalTo(false));
	}
	
	@Test
	public void negatedPredicate() {
		assertThat(greaterThan3.negate().test(4), equalTo(false));
		assertThat(greaterThan3.negate().test(3), equalTo(true));
	}
	
	@Test
	public void andPredicate() {
		Predicate<Integer> greaterThan3AndEven = greaterThan3.and(x -> x %2 == 0);
		assertThat(greaterThan3AndEven.test(4), equalTo(true));
		assertThat(greaterThan3AndEven.test(2), equalTo(false));
		assertThat(greaterThan3AndEven.test(5), equalTo(false));
	}
	
	@Test
	public void orPredicate() {
		Predicate<Integer> greaterThan3OrEven = greaterThan3.or(x -> x %2 == 0);
		assertThat(greaterThan3OrEven.test(4), equalTo(true));
		assertThat(greaterThan3OrEven.test(2), equalTo(true));
		assertThat(greaterThan3OrEven.test(5), equalTo(true));
		assertThat(greaterThan3OrEven.test(3), equalTo(false));
	}
	
	@Test
	public void predicateEqualTo() {
		//This tests the predicate returned by the static isEqual method
		Predicate<String> equalsFoo = Predicate.isEqual("foo");
		assertThat(equalsFoo.test("foo"), equalTo(true));
		assertThat(equalsFoo.test("bar"), equalTo(false));
	}
}
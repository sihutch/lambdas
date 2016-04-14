package com.ixxus.training.lambdas.methodreferences;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MethodReferenceArbitraryInstance {

	public static void main(String[] args) {

		// The following are equivalent.
		// First with a lamda then with a method reference
		List<String> names = Arrays.asList("BOB", "SUE", "FRED");

		System.out.println(
				names.stream()
						.map(s -> s.toLowerCase())
						.collect(Collectors.toList()));

		System.out.println(
				names.stream()
						.map(String::toLowerCase)
						.collect(Collectors.toList()));

		// We can replace a lambda expression with a method reference if it
		// directly routes the parameter as an argument to a method on another
		// instance

		BigInteger b1 = new BigInteger("10");
		BigInteger b2 = new BigInteger("20");

		// The following are equivalent.
		// First with a lamda then with a method reference
		System.out.println(MethodReferenceArbitraryInstance.op(b1, b2, (x, y) -> x.add(y)));
		System.out.println(MethodReferenceArbitraryInstance.op(b1, b2, BigInteger::add));
	}

	public static BigInteger op(BigInteger b1, BigInteger b2, BiFunction<BigInteger, BigInteger, BigInteger> func) {
		return func.apply(b1, b2);
	}
}
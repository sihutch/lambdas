package com.ixxus.training.lambdas.methodreferences;

import java.util.function.Function;

public class MethodReferenceStatic {

	public static void main(String[] args) {

		// The following are equivalent.
		// First with a lamda then with a method reference

		System.out.println(MethodReferenceStatic.apply(1, x -> String.valueOf(x)));
		System.out.println(MethodReferenceStatic.apply(1, String::valueOf));
	}

	public static String apply(Integer s, Function<Integer, String> func) {
		return func.apply(s);
	}
}
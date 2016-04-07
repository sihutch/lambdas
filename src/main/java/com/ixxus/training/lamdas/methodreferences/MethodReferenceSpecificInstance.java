package com.ixxus.training.lamdas.methodreferences;

import java.util.function.Function;

public class MethodReferenceSpecificInstance {

	public static void main(String[] args) {

		// The following are equivalent.
		// First with a lamda then with a method reference

		System.out.println(MethodReferenceSpecificInstance.apply(1, x -> String.valueOf(x)));
		System.out.println(MethodReferenceSpecificInstance.apply(1, String::valueOf));
	}

	public static String apply(Integer s, Function<Integer, String> func) {
		return func.apply(s);
	}
}
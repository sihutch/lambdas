package com.ixxus.training.lambdas.functionalinterfaces;

@FunctionalInterface
public interface FunctInterface {

	void abstractMethod();

	default String defaultMethod() {
		return "Foo";
	}

	static String staticMethod() {
		return "Foo";
	}
}
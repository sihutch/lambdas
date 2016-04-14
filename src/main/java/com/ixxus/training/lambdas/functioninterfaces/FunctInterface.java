package com.ixxus.training.lambdas.functioninterfaces;

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
package com.ixxus.training.lamdas.functioninterfaces;

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
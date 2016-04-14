package com.ixxus.training.lambdas.syntax;


public class CannotInfer {
	
	static class Value<T> {
	}

	@FunctionalInterface
	interface A<T> {
	  T apply(Value<T> value);
	}

	static class B {
	  public static <T> T test(A<T> callback) {
		  return null;
	  }
	}
	
	//Remove the (A<Boolean>) and it cannot infer the boolean 
	void test() {
	  B.test((A<Boolean>) value -> true).booleanValue();
	}
}
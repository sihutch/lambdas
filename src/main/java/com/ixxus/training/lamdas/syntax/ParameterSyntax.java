package com.ixxus.training.lamdas.syntax;

import java.util.function.BiFunction;

public class ParameterSyntax {
	
	public static void main(String[] args) {
		
		//Parameter types are explicitly declared
		BiFunction<Integer, Integer, Integer> declared = (Integer x, Integer y) -> x - y;
		
		//Parameter types are implicitly inferred
		BiFunction<Integer, Integer, Integer> inferred = (x, y) -> x - y;

		// Uncomment the statement below to show that 
		// declared and inferred is not allowed in the same expression
		// BiFunction<Integer, Integer, Integer> illegal = (Integer x, y) -> x - y;
	}
}
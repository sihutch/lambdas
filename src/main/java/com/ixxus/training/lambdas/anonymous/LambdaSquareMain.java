package com.ixxus.training.lambdas.anonymous;

import java.util.function.Function;

public class LambdaSquareMain {
	
	public static void main(String[] args) {
		Function<Integer, Integer> func = (Integer x) -> {return x * x;};
		System.out.println(func.apply(2));
	}
}
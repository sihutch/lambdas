package com.ixxus.training.lamdas.anonymous;

import java.util.function.Function;

public class LamdaSquareMain {
	
	public static void main(String[] args) {
		Function<Integer, Integer> func = (Integer x) -> {return x * x;};
		System.out.println(func.apply(2));
	}
}
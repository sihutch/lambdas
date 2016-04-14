package com.ixxus.training.lambdas.anonymous;

public class AnonSquareMain {

	public static void main(String[] args) {
		System.out.println((new AnonIntFunct() {
			@Override
			public int apply(int x) {
				return x * x;
			}
		}).apply(2));
	}
}
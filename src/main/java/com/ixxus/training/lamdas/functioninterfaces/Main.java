package com.ixxus.training.lamdas.functioninterfaces;

public class Main {

	public static void main(String[] args) {	
		FunctInterface withAnnotation = () -> System.out.println("Hello");
		withAnnotation.abstractMethod();
	
		FunctInterface2 withoutAnnotation = () -> System.out.println("Hello");
		withoutAnnotation.abstractMethod();		
		
		//Uncomment me to break compilation
		//withAnnotation = withoutAnnotation;
	}
}
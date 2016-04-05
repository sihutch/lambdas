package com.ixxus.training.lamdas.functioninterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class MainConsumer {
	
	public static void main(String[] args) {
		//Basic consumer
		Consumer<String> sayHello = s -> System.out.println("Hello " + s);
		sayHello.accept("World");
		
		//Consumers are commonly used with the forEach default method on Iterable 
		List<String> names = Arrays.asList("Sue", "Rita", "Bob");
		names.forEach(sayHello);
		
		//Consumer<T> has a default method andThen which allows consumers to be composed
		Consumer<String> furtherGreeting = sayHello.andThen(s -> System.out.println("How's things in the world of " + s +"?"));
		furtherGreeting.accept("Fred");
		
		//Autoboxing will work with primitives
		Consumer<Integer> printInt = i -> System.out.println("Hello " + i);
		printInt.accept(2); 
		
		//Use specialised primitive implementation to prevent lots of autoboxing
		IntConsumer primitivePrintInt = i -> System.out.println("Hello " + i);
		int[] massiveIntArray = {1,2,3};
		for (int j : massiveIntArray) {
			primitivePrintInt.accept(j);
		}
	}
}
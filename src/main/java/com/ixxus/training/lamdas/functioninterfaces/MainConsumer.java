package com.ixxus.training.lamdas.functioninterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
	}	
}
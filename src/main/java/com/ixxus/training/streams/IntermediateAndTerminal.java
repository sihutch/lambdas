package com.ixxus.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateAndTerminal {
	
	public static void main(String[] args) throws Exception {
		List<String> names = Arrays.asList("sean", "rita", "sue", "bob", "sally");

		System.out.println("Creating Stream\n");
		
		//Only intermediate operations are applied
		Stream<String> stream = names.stream()
				.filter(s -> s.startsWith("s")) 
				.peek(s -> System.out.println("Filter allowed: " + s))
				.map(s -> s.replaceFirst("s", "S"))
				.peek(s -> System.out.println("Mapped to " + s));

		// Although we have created the stream nothing
		// get printed to sysout until we call the terminal
		// method collect

		for (int i = 1; i < 4; i++) {
			System.out.println("Waiting " + i + "\n");
			Thread.sleep(1000);
		}

		System.out.println("\n" +
				stream.collect(Collectors.toList()));
	}
}
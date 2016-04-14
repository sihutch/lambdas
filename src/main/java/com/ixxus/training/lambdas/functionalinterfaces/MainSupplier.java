package com.ixxus.training.lambdas.functionalinterfaces;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainSupplier {
	
	public static void main(String[] args) {
		
		//Basic creation
		Supplier<UUID> randomUuidSupplier = () -> UUID.randomUUID();
		System.out.println(randomUuidSupplier.get());
		
		//commonly used with to create lazy infinite Streams
		System.out.println(
				Stream.generate(() -> UUID.randomUUID())
					  .limit(5)
					  .collect(Collectors.toList()));
		
		//also commonly used to supply an alternative result for an optional
		System.out.println(
				Optional.empty()
						.orElseGet(() -> "Supplied in place of empty option"));
	}
}
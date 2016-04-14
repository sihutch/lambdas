package com.ixxus.training.streams;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ixxus.training.lambdas.model.Bank;

public class IntermediateOperationFlatMap {

	public static void main(String[] args) throws Exception {
		listAccountNumbersForAllBanks();
		loremWordsOfLength(5);
	}
	
	//The flatMap over Bank objects gives us a stream of String(account numbers)
	private static void listAccountNumbersForAllBanks() {
		System.out.println("listAccountNumbersForAllBanks:" +
				Bank.BANK_LIST.stream()
						.flatMap(bank -> bank.getAccounts().stream())
						.collect(Collectors.toList()));
	}

	// An example of using Streams with I/O
	private static void loremWordsOfLength(int length) throws Exception {
		Path path = Paths.get(ClassLoader.getSystemResource("lorem.txt").toURI());
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)
				.flatMap(line -> Stream.of(line.split("\\W")))
				.filter(word -> word.length() == length)) {

			System.out.println("loremWordsOfLength " + length + ":" +
					lines.collect(Collectors.toList()));
		}
	}
}
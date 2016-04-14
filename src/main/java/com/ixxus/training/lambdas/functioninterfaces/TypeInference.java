package com.ixxus.training.lambdas.functioninterfaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TypeInference {

	public static void main(String[] args) {		
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(() -> System.out.println("Hello World"));
	}
}
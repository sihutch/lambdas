package com.ixxus.training.lamdas.methodreferences;

import java.math.BigInteger;
import java.util.function.Supplier;

public class MethodReferenceConstructor {

	public static void main(String[] args) {
		
		// The following are equivalent.
		// First with a lamda then with a method reference		
		System.out.println(MethodReferenceConstructor.supply(() -> new Object()));
		System.out.println(MethodReferenceConstructor.supply(Object::new));
		
		//It is possible (but ugly) to use specific constructors
		// The following are equivalent.
		// First with a lamda then with a method reference
		ConstructFunct cf = s -> new BigInteger(s);
		System.out.println(cf.fromStr("10"));
		//Because the method takes a String the BigInteger(String) constructor is referred
		ConstructFunct cf2 = BigInteger::new;
		System.out.println(cf2.fromStr("10"));
	}

	public static Object supply(Supplier<Object> supplier) {
		return supplier.get();
	}
	
	@FunctionalInterface
	interface ConstructFunct {
		BigInteger fromStr (String s);
	}
}
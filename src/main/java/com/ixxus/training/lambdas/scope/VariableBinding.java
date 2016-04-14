package com.ixxus.training.lambdas.scope;

public class VariableBinding {

	int field1 = 0; // Non final field can be referenced by lambda

	// Treated as final even if it is implicit
	private Runnable lamdaReferencedVariableEffectivelyFinal() {
		int i = 0;
		// Uncomment the code below to see compiler enforce final semantics
		return () -> {// i++;
		};
	}

	private Runnable nonFinalFieldAllowed() {
		return () -> field1++;
	}

	// It is possible to mutate state (bad idea) of the referenced array
	private Runnable mutationOfStateForFinalArrayTypeAllowed() {
		final int[] i = { 0 };
		return () -> i[0]++;
	}

	// It is possible to mutate state (bad idea) of the referenced array
	private Runnable mutationOfStateForFinalReferenceTypeAllowed() {
		final Person p = new Person();
		return () -> p.incrementAge();
	}
	
	class Person {
		int age =0;
		public void incrementAge() {
			age++;
		}
	}
}
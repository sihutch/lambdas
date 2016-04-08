package com.ixxus.training.lamdas.scope;

public class Scope {

	public static void main(String[] args) {
		Scope scope = new Scope();
		scope.anonymousScope();
		scope.lambdaScope();
	}

	private void anonymousScope() {
		int x = 1;

		Runnable r = new Runnable() {

			@Override
			public void run() {
				// Note that it is OK to define a variable with the same name
				// As a variable in the enclosing method
				int x = 2;
				System.out.println("Anonymous x " + x);
				System.out.println("Anonymous " + this.getClass());
			}
		};

		r.run();
	}

	private void lambdaScope() {
		
		int x = 1;
		
		Runnable r = () -> {
			// Uncomment the declaration below to show that a
			// Lambda cannot redeclare a variable from the enclosing scope
			//int x = 2;
			System.out.println(x);
			System.out.println("Lambda " + this.getClass());
		};

		r.run();
	}

	private void lambdaScopeOrderOfDeclaration() {

		Runnable r = () -> {int x = 2;}; //This is ok because x hasn't been declared yet

		int x = 1;
		
		Runnable r2 = () -> {
			// Uncomment the declaration below to show that a
			// declaration fails at this point because the enclosing method has
			// declared it
			//int x = 2;
		};
	}
}
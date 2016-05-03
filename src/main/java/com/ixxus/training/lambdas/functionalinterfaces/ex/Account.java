package com.ixxus.training.lambdas.functionalinterfaces.ex;

import java.util.function.Consumer;

public class Account {
		
	private String accountNumber;
	private String sortCode;
	private String holderName;
	
	private Account() {
		
	}
	
	public Account accountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}
	
	public Account sortCode(String sortCode) {
		this.sortCode = sortCode;
		return this;
	}
	
	public Account holderName(String holderName) {
		this.holderName = holderName;
		return this;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public String getHolderName() {
		return holderName;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", sortCode=" + sortCode + ", holderName=" + holderName + "]";
	}

	public static void create(final Consumer<Account> accountConsumer, AccountVerifier verifier) { 
		Account account = new Account();
		accountConsumer.accept(account);
		verifier.verify(account);
	}	
}
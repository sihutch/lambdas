package com.ixxus.training.lambdas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {
	
	public static List<Bank> BANK_LIST = new ArrayList<>();
	
	static {
		BANK_LIST.add(new Bank("HSBC", Arrays.asList("912345321", "912347622")));
		BANK_LIST.add(new Bank("Lloyds", Arrays.asList("864511111", "899513322")));
		BANK_LIST.add(new Bank("Santander", Arrays.asList("777348800", "777111100")));
	}
	private String name;
	private List<String> accounts;

	public Bank(String name, List<String> accounts) {
		this.name = name;
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public List<String> getAccounts() {
		return accounts;
	}
}
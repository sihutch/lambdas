package com.ixxus.training.lambdas.functionalinterfaces.ex.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.ixxus.training.lambdas.functionalinterfaces.ex.Account;
import com.ixxus.training.lambdas.functionalinterfaces.ex.AccountVerifier;

public class AccountTest {

	private static final String ACC_NUMBER = "99912123";
	private static final String SORT_CODE = "20-33-22";
	private static final String HOLDER_NAME = "Mr J.R Hartley";

	@Test
	public void accountIsCorrectlyCreated() {
		Account.create(account -> 
		 account.accountNumber(ACC_NUMBER)
				.sortCode(SORT_CODE)
				.holderName(HOLDER_NAME), new TestAccountVerifier());
	}

	class TestAccountVerifier implements AccountVerifier {
		@Override
		public void verify(Account account) {
			assertThat("Invalid account number", account.getAccountNumber(), equalTo(ACC_NUMBER));
			assertThat("Invalid sort code", account.getSortCode(), equalTo(SORT_CODE));
			assertThat("Invalid holder name", account.getHolderName(), equalTo(HOLDER_NAME));
		}
	}
}